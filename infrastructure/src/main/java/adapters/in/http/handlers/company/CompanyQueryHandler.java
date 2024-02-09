package adapters.in.http.handlers.company;

import adapters.in.http.handlers.company.contract.query.FindCompanyQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyQueryHandler {
    List<FindCompanyQueryResponse> findAll();

    FindCompanyQueryResponse findById(UUID id);
}
