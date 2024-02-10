package usecase.user.mapper;

import usecase.user.contract.command.CreateUserCommand;
import usecase.user.contract.command.CreateUserCommandResponse;
import org.springframework.stereotype.Component;
import domain.entity.User;
import domain.entity.valueobject.Email;
import domain.entity.valueobject.Password;
import domain.entity.valueobject.Username;
import usecase.user.contract.query.FindUserQueryResponse;

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