package ports.input.offeredservice.contract.command;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateOfferedService(
    UUID companyId, String name, String description, BigDecimal price) {}
