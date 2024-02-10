package usecase.category.contract;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record Company(
        UUID id,
        @NotEmpty String name,
        @NotEmpty String description,
        String image
) {}

