package usecase.mappers;

import entity.User;
import valueobject.Email;
import valueobject.Password;
import valueobject.UserRole;
import valueobject.Username;
import java.util.Optional;
import java.util.UUID;
import ports.input.user.contract.command.CreateUser;
import ports.input.user.contract.command.CreatedUser;
import ports.input.user.contract.query.FoundUser;

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
        extractId(user),
        extractEmail(user),
        extractFirstName(user),
        extractLastName(user),
        extractUsername(user),
        extractPassword(user),
        extractRole(user));
  }

  public FoundUser toFoundUser(User user) {
    return new FoundUser(
        extractId(user),
        extractUsername(user),
        extractFirstName(user),
        extractLastName(user),
        extractEmail(user),
        extractPassword(user),
        extractRole(user));
  }

  private UUID extractId(User user) {
    return Optional.ofNullable(user).map(User::getId).orElse(null);
  }

  private String extractEmail(User user) {
    return Optional.ofNullable(user).map(User::getEmail).map(Email::getValue).orElse(null);
  }

  private String extractFirstName(User user) {
    return Optional.ofNullable(user).map(User::getFirstName).orElse(null);
  }

  private String extractLastName(User user) {
    return Optional.ofNullable(user).map(User::getLastName).orElse(null);
  }

  private String extractUsername(User user) {
    return Optional.ofNullable(user).map(User::getUsername).map(Username::getValue).orElse(null);
  }

  private String extractPassword(User user) {
    return Optional.ofNullable(user).map(User::getPassword).map(Password::getValue).orElse(null);
  }

  private String extractRole(User user) {
    return Optional.ofNullable(user).map(User::getRole).map(UserRole::getValue).orElse(null);
  }
}
