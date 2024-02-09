package puc.appointify.application.rest.handlers.user.mapper;

import org.springframework.stereotype.Component;
import entity.User;
import entity.valueobject.Email;
import entity.valueobject.Password;
import entity.valueobject.UserRole;
import entity.valueobject.Username;
import puc.appointify.application.rest.handlers.user.contract.command.CreateUserCommand;
import puc.appointify.application.rest.handlers.user.contract.command.CreateUserCommandResponse;
import puc.appointify.application.rest.handlers.user.contract.query.FindUserQueryResponse;

@Component
public class UserMapper {
    public User createUserCommandToUser(CreateUserCommand command) {
        return new User(
                command.getFirstName(),
                command.getLastName(),
                new Username(command.getUsername()),
                new Email(command.getEmail()),
                new Password(command.getPassword()),
                command.getRole());
    }

    public CreateUserCommandResponse userToCreateUserCommandResponse(User user) {
        return CreateUserCommandResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail().getValue())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername().getValue())
                .password(user.getPassword().getValue())
                .role(user.getRole().getValue())
                .build();
    }

    public FindUserQueryResponse userToFindUserQueryResponse(User user) {
        return FindUserQueryResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail().getValue())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername().getValue())
                .password(user.getPassword().getValue())
                .role(user.getRole().getValue())
                .build();
    }
}
