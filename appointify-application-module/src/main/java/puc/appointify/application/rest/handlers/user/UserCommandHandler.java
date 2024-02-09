package puc.appointify.application.rest.handlers.user;

import puc.appointify.application.rest.handlers.user.contract.command.CreateUserCommand;
import puc.appointify.application.rest.handlers.user.contract.command.CreateUserCommandResponse;

public interface UserCommandHandler {
    CreateUserCommandResponse execute(CreateUserCommand command);
}
