package puc.appointify.application.rest.handlers.offeredservice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.offeredservice.OfferedServiceCommandHandler;
import puc.appointify.application.rest.handlers.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.application.rest.handlers.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import ports.output.repository.CompanyRepository;
import ports.output.repository.OfferedServiceRepository;
import common.exception.NotFoundException;
import puc.appointify.application.rest.handlers.offeredservice.mapper.OfferedServiceMapper;

@Component
@RequiredArgsConstructor
public class OfferedServiceCommandHandlerImpl implements OfferedServiceCommandHandler {
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
}