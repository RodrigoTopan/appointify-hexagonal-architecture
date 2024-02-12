package adapters.in.http.json.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import valueobject.UserRole;

public record CreateUserRequest(
    @NotEmpty String firstName,
    @NotEmpty String lastName,
    @NotEmpty String username,
    @Email String email,
    @NotEmpty String password,
    @NotNull UserRole role) {}
