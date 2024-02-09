package adapters.out;

import entity.Evaluation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.EvaluationRepository;
import adapters.out.jpa.EvaluationJpaRepository;
import adapters.out.mapper.EvaluationDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return evaluationJpaRepository
                .findAll()
                .stream()
                .map(EvaluationDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Evaluation findById(UUID id) {
        var entity = evaluationJpaRepository.findById(id).orElseThrow();
        return EvaluationDataAccessMapper.toDomain(entity);
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
