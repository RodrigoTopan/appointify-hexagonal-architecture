package puc.appointify.application.rest.handlers.evaluation;

import puc.appointify.application.rest.handlers.evaluation.contract.query.FindEvaluationQueryResponse;

import java.util.List;

public interface EvaluationQueryHandler {
    List<FindEvaluationQueryResponse> findAll();
}
