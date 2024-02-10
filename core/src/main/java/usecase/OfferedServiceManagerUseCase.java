package usecase;

import domain.common.exception.NotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import ports.input.OfferedServiceInputPort;
import ports.input.offeredservice.contract.command.CreateOfferedService;
import ports.input.offeredservice.contract.command.CreatedOfferedService;
import ports.input.offeredservice.contract.query.FindCompanyOfferedServices;
import ports.input.offeredservice.contract.query.FoundOfferedService;
import ports.output.repository.CompanyRepository;
import ports.output.repository.OfferedServiceRepository;
import usecase.mappers.OfferedServiceMapper;

public class OfferedServiceManagerUseCase implements OfferedServiceInputPort {
  private final OfferedServiceMapper mapper;
  private final CompanyRepository companyRepository;
  private final OfferedServiceRepository repository;

  public OfferedServiceManagerUseCase(
      OfferedServiceMapper mapper,
      CompanyRepository companyRepository,
      OfferedServiceRepository repository) {
    this.mapper = mapper;
    this.companyRepository = companyRepository;
    this.repository = repository;
  }

  @Override
  public CreatedOfferedService create(CreateOfferedService command) {
    var company = companyRepository.findById(command.companyId());
    if (company == null) throw new NotFoundException("not found registered company");

    var offeredService = mapper.createOfferedServiceCommandToOfferedService(company, command);
    var saved = repository.save(offeredService);
    return mapper.offeredServiceToCreateOfferedServiceCommandResponse(saved);
  }

  @Override
  public List<FoundOfferedService> findAll() {
    return repository
        .findAll()
        .stream()
        .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
        .collect(Collectors.toList());
  }

  @Override
  public FoundOfferedService findById(UUID id) {
    var offeredService = repository.findById(id);
    return mapper.offeredServiceToFindOfferedServiceQueryResponse(offeredService);
  }

  @Override
  public List<FoundOfferedService> find(FindCompanyOfferedServices query) {
    return repository
        .findAll()
        .stream()
        .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
        .collect(Collectors.toList());
  }
}
