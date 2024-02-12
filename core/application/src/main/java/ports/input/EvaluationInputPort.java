package ports.input;

import java.util.List;
import ports.input.evaluation.contract.command.CreateEvaluation;
import ports.input.evaluation.contract.command.CreatedEvaluation;
import ports.input.evaluation.contract.query.FoundEvaluation;

public interface EvaluationInputPort {
  CreatedEvaluation create(CreateEvaluation command);

  List<FoundEvaluation> findAll();
}
