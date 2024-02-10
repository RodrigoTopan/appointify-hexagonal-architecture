package ports.input.customer.contract.query;

import java.util.UUID;

public record FoundCustomer(UUID id, UUID userId) {}
