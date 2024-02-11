package adapters.in.http.json.offeredservice;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

public record CreateOfferedServiceRequest(
    @NotNull UUID companyId,
    @NotEmpty String name,
    @NotEmpty String description,
    @PositiveOrZero BigDecimal price) {}
