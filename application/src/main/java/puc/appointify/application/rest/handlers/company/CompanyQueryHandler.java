package puc.appointify.application.rest.handlers.company;

import puc.appointify.application.rest.handlers.company.contract.query.FindCompanyQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyQueryHandler {
    List<FindCompanyQueryResponse> findAll();

    FindCompanyQueryResponse findById(UUID id);
}
