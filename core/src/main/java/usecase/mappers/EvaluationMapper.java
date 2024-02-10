package usecase.mappers;

import domain.entity.Evaluation;
import ports.input.evaluation.contract.command.CreatedEvaluation;
import ports.input.evaluation.contract.query.FoundEvaluation;

public class EvaluationMapper {

  public CreatedEvaluation evaluationToCreateEvaluationCommandResponse(Evaluation evaluation) {
    return new CreatedEvaluation(
        evaluation.getRate(),
        evaluation.getComment(),
        evaluation.getCustomer().getId(),
        evaluation.getEmployee().getId());
  }

  public FoundEvaluation evaluationToFindEvaluationQueryResponse(Evaluation evaluation) {
    return new FoundEvaluation(
        evaluation.getRate(),
        evaluation.getComment(),
        evaluation.getCustomer().getId(),
        evaluation.getEmployee().getId());
  }
}
