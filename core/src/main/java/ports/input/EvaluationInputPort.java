package ports.input;

import usecase.evaluation.contract.command.CreateEvaluationCommand;
import usecase.evaluation.contract.command.CreateEvaluationCommandResponse;
import usecase.evaluation.contract.query.FindEvaluationQueryResponse;

import java.util.List;

public interface EvaluationInputPort {
    CreateEvaluationCommandResponse create(CreateEvaluationCommand command);
    List<FindEvaluationQueryResponse> findAll();
}
