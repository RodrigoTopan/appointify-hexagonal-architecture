package adapters.in.http.json.evaluation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CreateEvaluationRequest(
    @Min(0) @Max(5) Integer rate,
    @NotEmpty String comment,
    @NotNull UUID employeeId,
    @NotNull UUID customerId) {}
