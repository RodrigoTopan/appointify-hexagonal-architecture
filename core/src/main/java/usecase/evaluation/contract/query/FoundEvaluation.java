package usecase.evaluation.contract.query;

import java.util.UUID;

public record FoundEvaluation(Integer rate, String comment, UUID employeeId, UUID customerId) {}

