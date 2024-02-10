package usecase.user.contract.query;

import jakarta.validation.constraints.NotEmpty;

public record FindUser(@NotEmpty String username) {}

