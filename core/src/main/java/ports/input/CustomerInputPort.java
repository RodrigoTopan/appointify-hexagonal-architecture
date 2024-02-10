package ports.input;

import usecase.customer.contract.command.CreateCustomerCommand;
import usecase.customer.contract.command.CreateCustomerCommandResponse;
import usecase.customer.contract.query.FindCustomerQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerInputPort {
    CreateCustomerCommandResponse create(CreateCustomerCommand command);

    void deleteById(UUID id);

    List<FindCustomerQueryResponse> findAll();

    FindCustomerQueryResponse findById(UUID id);
}
