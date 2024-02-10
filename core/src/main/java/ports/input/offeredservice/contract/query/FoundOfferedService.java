package ports.input.offeredservice.contract.query;

import java.math.BigDecimal;
import java.util.UUID;

public record FoundOfferedService(
    UUID id, UUID companyId, String name, String description, BigDecimal price) {}
