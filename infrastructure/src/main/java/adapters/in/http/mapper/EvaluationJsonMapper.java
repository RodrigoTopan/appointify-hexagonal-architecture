package adapters.in.http.mapper;

import adapters.in.http.json.evaluation.CreateEvaluationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.evaluation.contract.command.CreateEvaluation;

@Mapper(componentModel = "spring")
public interface EvaluationJsonMapper {
  EvaluationJsonMapper INSTANCE = Mappers.getMapper(EvaluationJsonMapper.class);

  CreateEvaluation toCommand(CreateEvaluationRequest request);
}
