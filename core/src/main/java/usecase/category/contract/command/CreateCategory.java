package usecase.category.contract.command;

import jakarta.validation.constraints.NotEmpty;

public record CreateCategory(
        @NotEmpty String name,
        String image
) {}


