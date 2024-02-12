package ports.input.user.contract.command;

import valueobject.UserRole;

public record CreateUser(
    String firstName,
    String lastName,
    String username,
    String email,
    String password,
    UserRole role) {}
