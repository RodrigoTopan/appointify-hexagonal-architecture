package ports.input;

import usecase.customer.contract.command.CreateCustomer;
import usecase.customer.contract.command.CreatedCustomer;
import usecase.customer.contract.query.FoundCustomer;

import java.util.List;
import java.util.UUID;

public interface CustomerInputPort {
    CreatedCustomer create(CreateCustomer command);

    void deleteById(UUID id);

    List<FoundCustomer> findAll();

    FoundCustomer findById(UUID id);
}
