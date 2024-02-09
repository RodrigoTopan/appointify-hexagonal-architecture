package adapters.in.http.handlers.evaluation;

import adapters.in.http.handlers.evaluation.contract.query.FindEvaluationQueryResponse;

import java.util.List;

public interface EvaluationQueryHandler {
    List<FindEvaluationQueryResponse> findAll();
}
