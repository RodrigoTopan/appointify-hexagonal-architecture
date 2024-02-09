package adapters.in.http.handlers.customer;

import adapters.in.http.handlers.customer.contract.command.CreateCustomerCommand;
import adapters.in.http.handlers.customer.contract.command.CreateCustomerCommandResponse;

import java.util.UUID;

public interface CustomerCommandHandler {
    CreateCustomerCommandResponse create(CreateCustomerCommand command);

    void deleteById(UUID id);
}
