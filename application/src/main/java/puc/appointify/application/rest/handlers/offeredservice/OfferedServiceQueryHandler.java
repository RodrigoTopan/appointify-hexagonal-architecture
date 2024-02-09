package puc.appointify.application.rest.handlers.offeredservice;

import puc.appointify.application.rest.handlers.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import puc.appointify.application.rest.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

public interface OfferedServiceQueryHandler {
    List<FindOfferedServiceQueryResponse> findAll();

    FindOfferedServiceQueryResponse findById(UUID id);
    List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query);
}
