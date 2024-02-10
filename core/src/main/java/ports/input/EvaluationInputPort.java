package ports.input;

import java.util.List;
import usecase.evaluation.contract.command.CreateEvaluation;
import usecase.evaluation.contract.command.CreatedEvaluation;
import usecase.evaluation.contract.query.FoundEvaluation;

public interface EvaluationInputPort {
  CreatedEvaluation create(CreateEvaluation command);

  List<FoundEvaluation> findAll();
}
