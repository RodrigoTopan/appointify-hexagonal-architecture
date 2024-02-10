package usecase.evaluation.mapper;

import org.springframework.stereotype.Component;
import domain.entity.Evaluation;
import usecase.evaluation.contract.command.CreatedEvaluation;
import usecase.evaluation.contract.query.FoundEvaluation;

@Component
public class EvaluationMapper {

    public CreatedEvaluation evaluationToCreateEvaluationCommandResponse(Evaluation evaluation) {
        return new CreatedEvaluation(
                evaluation.getRate(),
                evaluation.getComment(),
                evaluation.getCustomer().getId(),
                evaluation.getEmployee().getId()
        );
    }

    public FoundEvaluation evaluationToFindEvaluationQueryResponse(Evaluation evaluation) {
        return new FoundEvaluation(
                evaluation.getRate(),
                evaluation.getComment(),
                evaluation.getCustomer().getId(),
                evaluation.getEmployee().getId()
        );
    }


}
