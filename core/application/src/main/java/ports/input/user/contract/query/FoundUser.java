package ports.input.user.contract.query;

import java.util.UUID;

public record FoundUser(
    UUID id,
    String username,
    String firstName,
    String lastName,
    String email,
    String password,
    String role) {}
