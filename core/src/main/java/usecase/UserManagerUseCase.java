package usecase;

import usecase.user.contract.command.CreateUser;
import usecase.user.contract.command.CreateUserResult;
import usecase.user.contract.query.FindUser;
import usecase.user.contract.query.FindUserResult;
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
    public CreateUserResult create(CreateUser command) {
        var user = userMapper.createUserCommandToUser(command);
        var registeredUser = userRepository.save(user);
        return userMapper.userToCreateUserCommandResponse(registeredUser);
    }

    @Override
    public FindUserResult find(FindUser query) {
        var user = userRepository.findByUsername(query.getUsername());
        return userMapper.userToFindUserQueryResponse(user);
    }
}
