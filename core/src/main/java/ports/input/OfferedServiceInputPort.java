package ports.input;

import java.util.List;
import java.util.UUID;
import ports.input.offeredservice.contract.command.CreateOfferedService;
import ports.input.offeredservice.contract.command.CreatedOfferedService;
import ports.input.offeredservice.contract.query.FindCompanyOfferedServices;
import ports.input.offeredservice.contract.query.FoundOfferedService;

public interface OfferedServiceInputPort {
  CreatedOfferedService create(CreateOfferedService command);

  List<FoundOfferedService> findAll();

  FoundOfferedService findById(UUID id);

  List<FoundOfferedService> find(FindCompanyOfferedServices query);
}
