package adapters.in.http.json.employee;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CreateEmployeeRequest(@NotNull UUID userId, @NotNull UUID companyId) {}
