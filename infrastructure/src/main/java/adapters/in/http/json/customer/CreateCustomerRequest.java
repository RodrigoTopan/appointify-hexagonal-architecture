package adapters.in.http.json.customer;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CreateCustomerRequest(@NotNull UUID userId) {}
