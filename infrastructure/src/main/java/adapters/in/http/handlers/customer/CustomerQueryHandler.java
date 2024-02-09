package adapters.in.http.handlers.customer;

import adapters.in.http.handlers.customer.contract.query.FindCustomerQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerQueryHandler {
    List<FindCustomerQueryResponse> findAll();

    FindCustomerQueryResponse findById(UUID id);
}
