package ports.input.schedules.contract;

import java.math.BigDecimal;
import java.util.UUID;

public record Service(UUID id, String name, String description, BigDecimal price) {
}
