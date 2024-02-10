package usecase;

import usecase.user.contract.command.CreateUser;
import usecase.user.contract.command.CreatedUser;
import usecase.user.contract.query.FindUser;
import usecase.user.contract.query.FoundUser;
import usecase.user.mapper.UserMapper;
import ports.input.UserInputPort;
import ports.output.repository.UserRepository;


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
        var user = userRepository.findByUsername(query.getUsername());
        return userMapper.toFoundUser(user);
    }
}
