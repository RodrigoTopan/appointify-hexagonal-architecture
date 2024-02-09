package puc.appointify.application.rest.handlers.offeredservice;

import puc.appointify.application.rest.handlers.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.application.rest.handlers.offeredservice.contract.command.CreateOfferedServiceCommandResponse;

public interface OfferedServiceCommandHandler {
    CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command);
}
