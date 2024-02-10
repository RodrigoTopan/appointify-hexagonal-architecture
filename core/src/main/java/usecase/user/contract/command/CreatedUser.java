package usecase.user.contract.command;

import java.util.UUID;

public record CreatedUser(
        UUID id,
        String username,
        String firstName,
        String lastName,
        String email,
        String password,
        String role
) {
}
