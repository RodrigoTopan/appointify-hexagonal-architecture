package usecase.evaluation.mapper;

import org.springframework.stereotype.Component;
import domain.entity.Evaluation;
import usecase.evaluation.contract.command.CreateEvaluationResult;
import usecase.evaluation.contract.query.FindEvaluationResult;

@Component
public class EvaluationMapper {

    public CreateEvaluationResult evaluationToCreateEvaluationCommandResponse(Evaluation evaluation) {
        return CreateEvaluationResult
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

    public FindEvaluationResult evaluationToFindEvaluationQueryResponse(Evaluation evaluation) {
        return FindEvaluationResult
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

}
