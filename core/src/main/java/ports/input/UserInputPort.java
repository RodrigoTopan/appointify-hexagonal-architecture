package ports.input;

import usecase.user.contract.command.CreateUser;
import usecase.user.contract.command.CreatedUser;
import usecase.user.contract.query.FindUser;
import usecase.user.contract.query.FoundUser;

public interface UserInputPort {
  CreatedUser create(CreateUser command);

  FoundUser find(FindUser query);
}
