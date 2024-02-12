package usecase.mappers;

import entity.Evaluation;
import java.util.UUID;
import ports.input.evaluation.contract.command.CreatedEvaluation;
import ports.input.evaluation.contract.query.FoundEvaluation;

public class EvaluationMapper {

  public CreatedEvaluation evaluationToCreateEvaluationCommandResponse(Evaluation evaluation) {
    return new CreatedEvaluation(
        extractRate(evaluation),
        extractComment(evaluation),
        extractCustomerId(evaluation),
        extractEmployeeId(evaluation));
  }

  public FoundEvaluation evaluationToFindEvaluationQueryResponse(Evaluation evaluation) {
    return new FoundEvaluation(
        extractRate(evaluation),
        extractComment(evaluation),
        extractCustomerId(evaluation),
        extractEmployeeId(evaluation));
  }

  private Integer extractRate(Evaluation evaluation) {
    return evaluation != null ? evaluation.getRate() : null;
  }

  private String extractComment(Evaluation evaluation) {
    return evaluation != null ? evaluation.getComment() : null;
  }

  private UUID extractCustomerId(Evaluation evaluation) {
    return evaluation != null && evaluation.getCustomer() != null
        ? evaluation.getCustomer().getId()
        : null;
  }

  private UUID extractEmployeeId(Evaluation evaluation) {
    return evaluation != null && evaluation.getEmployee() != null
        ? evaluation.getEmployee().getId()
        : null;
  }
}
