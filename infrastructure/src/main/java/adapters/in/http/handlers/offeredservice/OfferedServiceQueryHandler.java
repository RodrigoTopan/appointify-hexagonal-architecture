package adapters.in.http.handlers.offeredservice;

import adapters.in.http.handlers.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import adapters.in.http.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

public interface OfferedServiceQueryHandler {
    List<FindOfferedServiceQueryResponse> findAll();

    FindOfferedServiceQueryResponse findById(UUID id);
    List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query);
}
