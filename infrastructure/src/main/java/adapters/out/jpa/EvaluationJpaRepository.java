package adapters.out.jpa;

import adapters.out.entity.EvaluationEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationJpaRepository extends JpaRepository<EvaluationEntity, UUID> {
  List<EvaluationEntity> findByCustomerId(UUID customerId);
}
