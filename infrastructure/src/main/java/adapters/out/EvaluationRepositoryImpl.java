package adapters.out;

import adapters.out.postgres.jpa.EvaluationJpaRepository;
import adapters.out.postgres.mapper.EvaluationDataAccessMapper;
import entity.Evaluation;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.EvaluationRepository;

@Component
@RequiredArgsConstructor
public class EvaluationRepositoryImpl implements EvaluationRepository {
  private final EvaluationJpaRepository evaluationJpaRepository;

  @Override
  public Evaluation save(Evaluation evaluation) {
    var entity = EvaluationDataAccessMapper.toEntity(evaluation);
    return EvaluationDataAccessMapper.toDomain(evaluationJpaRepository.save(entity));
  }

  @Override
  public List<Evaluation> findAll() {
    return evaluationJpaRepository.findAll().stream()
        .map(EvaluationDataAccessMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Evaluation findById(UUID id) {
    var entity = evaluationJpaRepository.findById(id);
    return entity.map(EvaluationDataAccessMapper::toDomain).orElse(null);
  }

  @Override
  public List<Evaluation> findByCustomerId(UUID id) {
    return evaluationJpaRepository.findByCustomerId(id).stream()
        .map(EvaluationDataAccessMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(UUID id) {
    evaluationJpaRepository.deleteById(id);
  }
}
