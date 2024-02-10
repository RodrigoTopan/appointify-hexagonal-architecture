package ports.input;

import java.util.List;
import java.util.UUID;
import usecase.offeredservice.contract.command.CreateOfferedService;
import usecase.offeredservice.contract.command.CreatedOfferedService;
import usecase.offeredservice.contract.query.FindCompanyOfferedServices;
import usecase.offeredservice.contract.query.FoundOfferedService;

public interface OfferedServiceInputPort {
  CreatedOfferedService create(CreateOfferedService command);

  List<FoundOfferedService> findAll();

  FoundOfferedService findById(UUID id);

  List<FoundOfferedService> find(FindCompanyOfferedServices query);
}
