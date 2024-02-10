package usecase.category.contract.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreatedCategory(
        @NotNull UUID id,
        @NotEmpty String name,
        String image
) {}


