package usecase.user.mapper;

import usecase.user.contract.command.CreateUser;
import usecase.user.contract.command.CreatedUser;
import org.springframework.stereotype.Component;
import domain.entity.User;
import domain.valueobject.Email;
import domain.valueobject.Password;
import domain.valueobject.Username;
import usecase.user.contract.query.FoundUser;

@Component
public class UserMapper {
    public User toUser(CreateUser command) {
        return new User(
                command.firstName(),
                command.lastName(),
                new Username(command.username()),
                new Email(command.email()),
                new Password(command.password()),
                command.role());
    }

    public CreatedUser toCreatedUser(User user) {
        return new CreatedUser(
                user.getId(),
                user.getEmail().getValue(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername().getValue(),
                user.getPassword().getValue(),
                user.getRole().getValue());
    }

    public FoundUser toFoundUser(User user) {
        return FoundUser
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
