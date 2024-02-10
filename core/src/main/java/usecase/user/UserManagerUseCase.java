package usecase.user;

import usecase.user.contract.command.CreateUserCommand;
import usecase.user.contract.command.CreateUserCommandResponse;
import usecase.user.contract.query.FindUserQuery;
import usecase.user.contract.query.FindUserQueryResponse;
import usecase.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.UserInputPort;
import ports.output.repository.UserRepository;


@Component
@RequiredArgsConstructor
public class UserManagerUseCase implements UserInputPort {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public CreateUserCommandResponse create(CreateUserCommand command) {
        var user = userMapper.createUserCommandToUser(command);
        var registeredUser = userRepository.save(user);
        return userMapper.userToCreateUserCommandResponse(registeredUser);
    }

    @Override
    public FindUserQueryResponse find(FindUserQuery query) {
        var user = userRepository.findByUsername(query.getUsername());
        return userMapper.userToFindUserQueryResponse(user);
    }
}
