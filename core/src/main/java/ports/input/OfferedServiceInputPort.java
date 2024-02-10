package ports.input;

import usecase.offeredservice.contract.command.CreateOfferedService;
import usecase.offeredservice.contract.command.CreateOfferedServiceResult;
import usecase.offeredservice.contract.query.FindCompanyOfferedServices;
import usecase.offeredservice.contract.query.FindOfferedServiceQueryResult;

import java.util.List;
import java.util.UUID;

public interface OfferedServiceInputPort {
    CreateOfferedServiceResult create(CreateOfferedService command);
    List<FindOfferedServiceQueryResult> findAll();

    FindOfferedServiceQueryResult findById(UUID id);
    List<FindOfferedServiceQueryResult> find(FindCompanyOfferedServices query);
}
