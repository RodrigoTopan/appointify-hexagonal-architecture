package puc.appointify.application.rest.handlers.evaluation.mapper;

import org.springframework.stereotype.Component;
import entity.Evaluation;
import puc.appointify.application.rest.handlers.evaluation.contract.command.CreateEvaluationCommandResponse;
import puc.appointify.application.rest.handlers.evaluation.contract.query.FindEvaluationQueryResponse;

@Component
public class EvaluationMapper {

    public CreateEvaluationCommandResponse evaluationToCreateEvaluationCommandResponse(Evaluation evaluation) {
        return CreateEvaluationCommandResponse
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

    public FindEvaluationQueryResponse evaluationToFindEvaluationQueryResponse(Evaluation evaluation) {
        return FindEvaluationQueryResponse
                .builder()
                .rate(evaluation.getRate())
                .comment(evaluation.getComment())
                .customerId(evaluation.getCustomer().getId())
                .employeeId(evaluation.getEmployee().getId())
                .build();
    }

}
