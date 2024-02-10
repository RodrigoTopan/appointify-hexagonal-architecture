package usecase.evaluation.contract.command;

import java.util.UUID;

public record CreatedEvaluation(Integer rate, String comment, UUID employeeId, UUID customerId) {}

