package usecase.company.contract;

import jakarta.validation.constraints.NotEmpty;

public record Company(
        @NotEmpty String name,
        @NotEmpty String description,
        @NotEmpty String governmentId,
        String image
) {}


