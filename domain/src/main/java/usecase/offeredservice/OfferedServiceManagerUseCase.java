package usecase.offeredservice;

import usecase.offeredservice.contract.command.CreateOfferedServiceCommand;
import usecase.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import usecase.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import usecase.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.OfferedServiceInputPort;
import ports.output.repository.CompanyRepository;
import ports.output.repository.OfferedServiceRepository;
import common.exception.NotFoundException;
import usecase.offeredservice.mapper.OfferedServiceMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferedServiceManagerUseCase implements OfferedServiceInputPort {
    private final OfferedServiceMapper mapper;
    private final CompanyRepository companyRepository;
    private final OfferedServiceRepository repository;

    @Override
    public CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command) {
        var company = companyRepository.findById(command.getCompanyId());
        if (company == null)
            throw new NotFoundException("not found registered company");

        var offeredService = mapper.createOfferedServiceCommandToOfferedService(company, command);
        var saved = repository.save(offeredService);
        return mapper.offeredServiceToCreateOfferedServiceCommandResponse(saved);
    }

    @Override
    public List<FindOfferedServiceQueryResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindOfferedServiceQueryResponse findById(UUID id) {
        var offeredService = repository.findById(id);
        return mapper.offeredServiceToFindOfferedServiceQueryResponse(offeredService);
    }

    @Override
    public List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query) {
        return repository.findAll()
                .stream()
                .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
                .collect(Collectors.toList());
    }
}