package ports.input;

import usecase.user.contract.command.CreateUser;
import usecase.user.contract.command.CreateUserResult;
import usecase.user.contract.query.FindUser;
import usecase.user.contract.query.FindUserResult;

public interface UserInputPort {
    CreateUserResult create(CreateUser command);
    FindUserResult find(FindUser query);
}
