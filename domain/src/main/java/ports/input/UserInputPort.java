package ports.input;

import usecase.user.contract.command.CreateUserCommand;
import usecase.user.contract.command.CreateUserCommandResponse;
import usecase.user.contract.query.FindUserQuery;
import usecase.user.contract.query.FindUserQueryResponse;

public interface UserInputPort {
    CreateUserCommandResponse create(CreateUserCommand command);
    FindUserQueryResponse find(FindUserQuery query);
}
