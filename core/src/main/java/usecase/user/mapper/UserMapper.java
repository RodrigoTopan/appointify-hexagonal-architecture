package usecase.user.mapper;

import usecase.user.contract.command.CreateUser;
import usecase.user.contract.command.CreateUserResult;
import org.springframework.stereotype.Component;
import domain.entity.User;
import domain.entity.valueobject.Email;
import domain.entity.valueobject.Password;
import domain.entity.valueobject.Username;
import usecase.user.contract.query.FindUserResult;

@Component
public class UserMapper {
    public User createUserCommandToUser(CreateUser command) {
        return new User(
                command.getFirstName(),
                command.getLastName(),
                new Username(command.getUsername()),
                new Email(command.getEmail()),
                new Password(command.getPassword()),
                command.getRole());
    }

    public CreateUserResult userToCreateUserCommandResponse(User user) {
        return CreateUserResult
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

    public FindUserResult userToFindUserQueryResponse(User user) {
        return FindUserResult
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
