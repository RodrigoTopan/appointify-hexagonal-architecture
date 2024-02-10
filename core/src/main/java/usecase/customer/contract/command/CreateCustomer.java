package usecase.customer.contract.command;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateCustomer(
        @NotNull UUID userId
) {}

