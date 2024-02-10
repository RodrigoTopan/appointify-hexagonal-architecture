package ports.input;

import usecase.evaluation.contract.command.CreateEvaluation;
import usecase.evaluation.contract.command.CreateEvaluationResult;
import usecase.evaluation.contract.query.FindEvaluationResult;

import java.util.List;

public interface EvaluationInputPort {
    CreateEvaluationResult create(CreateEvaluation command);
    List<FindEvaluationResult> findAll();
}
