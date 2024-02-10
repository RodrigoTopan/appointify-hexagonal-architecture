package ports.input;

import usecase.evaluation.contract.command.CreateEvaluation;
import usecase.evaluation.contract.command.CreatedEvaluation;
import usecase.evaluation.contract.query.FoundEvaluation;

import java.util.List;

public interface EvaluationInputPort {
    CreatedEvaluation create(CreateEvaluation command);
    List<FoundEvaluation> findAll();
}
