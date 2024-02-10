package ports.input.customer.contract.command;

import java.util.UUID;

public record CreatedCustomer(
        UUID id,
        UUID userId
) {
}
