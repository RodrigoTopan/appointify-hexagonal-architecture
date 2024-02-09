package adapters.in.http.handlers.user;

import adapters.in.http.handlers.user.contract.command.CreateUserCommand;
import adapters.in.http.handlers.user.contract.command.CreateUserCommandResponse;

public interface UserCommandHandler {
    CreateUserCommandResponse execute(CreateUserCommand command);
}
