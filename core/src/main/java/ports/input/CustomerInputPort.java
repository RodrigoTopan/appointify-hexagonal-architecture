package ports.input;

import usecase.customer.contract.command.CreateCustomer;
import usecase.customer.contract.command.CreateCustomerResult;
import usecase.customer.contract.query.FindCustomerResult;

import java.util.List;
import java.util.UUID;

public interface CustomerInputPort {
    CreateCustomerResult create(CreateCustomer command);

    void deleteById(UUID id);

    List<FindCustomerResult> findAll();

    FindCustomerResult findById(UUID id);
}
