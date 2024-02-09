package puc.appointify.application.rest.handlers.evaluation;

import puc.appointify.application.rest.handlers.evaluation.contract.command.CreateEvaluationCommand;
import puc.appointify.application.rest.handlers.evaluation.contract.command.CreateEvaluationCommandResponse;

public interface EvaluationCommandHandler {
    CreateEvaluationCommandResponse create(CreateEvaluationCommand command);
}
