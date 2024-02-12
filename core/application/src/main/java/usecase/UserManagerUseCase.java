package usecase;

import exception.NotFoundException;
import ports.input.UserInputPort;
import ports.input.user.contract.command.CreateUser;
import ports.input.user.contract.command.CreatedUser;
import ports.input.user.contract.query.FindUser;
import ports.input.user.contract.query.FoundUser;
import ports.output.repository.UserRepository;
import usecase.mappers.UserMapper;

public class UserManagerUseCase implements UserInputPort {
  private final UserMapper userMapper;
  private final UserRepository userRepository;

  public UserManagerUseCase(UserMapper userMapper, UserRepository userRepository) {
    this.userMapper = userMapper;
    this.userRepository = userRepository;
  }

  @Override
  public CreatedUser create(CreateUser command) {
    var user = userMapper.toUser(command);
    var registeredUser = userRepository.save(user);
    return userMapper.toCreatedUser(registeredUser);
  }

  @Override
  public FoundUser find(FindUser query) {
    var user = userRepository.findByUsername(query.username());
    if (user == null) {
      throw new NotFoundException("User not found");
    }
    return userMapper.toFoundUser(user);
  }
}
