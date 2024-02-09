package adapters.in.http.handlers.offeredservice;

import adapters.in.http.handlers.offeredservice.contract.command.CreateOfferedServiceCommand;
import adapters.in.http.handlers.offeredservice.contract.command.CreateOfferedServiceCommandResponse;

public interface OfferedServiceCommandHandler {
    CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command);
}
