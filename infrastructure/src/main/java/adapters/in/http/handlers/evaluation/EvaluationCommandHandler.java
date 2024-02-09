package adapters.in.http.handlers.evaluation;

import adapters.in.http.handlers.evaluation.contract.command.CreateEvaluationCommand;
import adapters.in.http.handlers.evaluation.contract.command.CreateEvaluationCommandResponse;

public interface EvaluationCommandHandler {
    CreateEvaluationCommandResponse create(CreateEvaluationCommand command);
}
