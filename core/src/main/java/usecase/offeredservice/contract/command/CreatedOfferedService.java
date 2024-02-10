package usecase.offeredservice.contract.command;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatedOfferedService(UUID id, UUID companyId, String name, String description, BigDecimal price) {}

