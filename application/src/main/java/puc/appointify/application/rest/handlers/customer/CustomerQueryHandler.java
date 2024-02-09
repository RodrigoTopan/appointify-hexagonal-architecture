package puc.appointify.application.rest.handlers.customer;

import puc.appointify.application.rest.handlers.customer.contract.query.FindCustomerQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerQueryHandler {
    List<FindCustomerQueryResponse> findAll();

    FindCustomerQueryResponse findById(UUID id);
}
