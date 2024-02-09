package adapters.in.http.handlers.user.impl;

import adapters.in.http.handlers.user.UserCommandHandler;
import adapters.in.http.handlers.user.contract.command.CreateUserCommand;
import adapters.in.http.handlers.user.contract.command.CreateUserCommandResponse;
import adapters.in.http.handlers.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.UserRepository;


@Component
@RequiredArgsConstructor
public class UserCommandHandlerImpl implements UserCommandHandler {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public CreateUserCommandResponse execute(CreateUserCommand command) {
        var user = userMapper.createUserCommandToUser(command);
        var registeredUser = userRepository.save(user);
        return userMapper.userToCreateUserCommandResponse(registeredUser);
    }

}
