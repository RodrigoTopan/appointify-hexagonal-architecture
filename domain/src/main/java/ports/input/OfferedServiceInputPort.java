package ports.input;

import usecase.offeredservice.contract.command.CreateOfferedServiceCommand;
import usecase.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import usecase.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import usecase.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

public interface OfferedServiceInputPort {
    CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command);
    List<FindOfferedServiceQueryResponse> findAll();

    FindOfferedServiceQueryResponse findById(UUID id);
    List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query);
}
