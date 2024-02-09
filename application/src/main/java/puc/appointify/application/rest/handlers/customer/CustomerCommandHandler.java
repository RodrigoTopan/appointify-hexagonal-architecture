package puc.appointify.application.rest.handlers.customer;

import puc.appointify.application.rest.handlers.customer.contract.command.CreateCustomerCommand;
import puc.appointify.application.rest.handlers.customer.contract.command.CreateCustomerCommandResponse;

import java.util.UUID;

public interface CustomerCommandHandler {
    CreateCustomerCommandResponse create(CreateCustomerCommand command);

    void deleteById(UUID id);
}
