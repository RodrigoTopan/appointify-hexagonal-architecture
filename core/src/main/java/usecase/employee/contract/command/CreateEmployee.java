package usecase.employee.contract.command;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateEmployee(
        @NotNull UUID userId,
        @NotNull UUID companyId
) {}


