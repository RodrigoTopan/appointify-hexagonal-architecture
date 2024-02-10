package usecase.evaluation.contract.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateEvaluation(
        @Min(0) @Max(5) Integer rate,
        @NotEmpty String comment,
        @NotNull UUID employeeId,
        @NotNull UUID customerId
) {}

