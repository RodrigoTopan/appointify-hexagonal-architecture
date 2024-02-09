package puc.appointify.application.rest.handlers.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.user.mapper.UserMapper;
import ports.output.repository.UserRepository;
import puc.appointify.application.rest.handlers.user.UserCommandHandler;
import puc.appointify.application.rest.handlers.user.contract.command.CreateUserCommand;
import puc.appointify.application.rest.handlers.user.contract.command.CreateUserCommandResponse;


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
