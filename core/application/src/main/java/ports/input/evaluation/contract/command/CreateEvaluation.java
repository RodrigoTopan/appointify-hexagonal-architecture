package ports.input.evaluation.contract.command;

import java.util.UUID;

public record CreateEvaluation(Integer rate, String comment, UUID employeeId, UUID customerId) {}
