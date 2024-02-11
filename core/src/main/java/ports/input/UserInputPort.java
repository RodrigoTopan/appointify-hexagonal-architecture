package ports.input;

import ports.input.user.contract.command.CreateUser;
import ports.input.user.contract.command.CreatedUser;
import ports.input.user.contract.query.FindUser;
import ports.input.user.contract.query.FoundUser;

public interface UserInputPort {
  CreatedUser create(CreateUser command);

  FoundUser find(FindUser query);
}
