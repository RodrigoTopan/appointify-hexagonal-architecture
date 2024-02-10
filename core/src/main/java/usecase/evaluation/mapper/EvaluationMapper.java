package usecase.evaluation.mapper;

import org.springframework.stereotype.Component;
import domain.entity.Evaluation;
import usecase.evaluation.contract.command.CreatedEvaluation;
import usecase.evaluation.contract.query.FoundEvaluation;

@Component
public class EvaluationMapper {

    public CreatedEvaluation evaluationToCreateEvaluationCommandResponse(Evaluation evaluation) {
        return CreatedEvaluation
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

    public FoundEvaluation evaluationToFindEvaluationQueryResponse(Evaluation evaluation) {
        return FoundEvaluation
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

}
