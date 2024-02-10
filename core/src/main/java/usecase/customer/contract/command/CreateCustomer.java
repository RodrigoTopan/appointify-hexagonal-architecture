package usecase.customer.contract.command;

import java.util.UUID;

public record CreateCustomer(
        UUID userId
) {}

