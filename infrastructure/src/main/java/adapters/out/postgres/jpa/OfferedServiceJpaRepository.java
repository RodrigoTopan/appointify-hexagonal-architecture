package adapters.out.postgres.jpa;

import adapters.out.postgres.entity.OfferedServiceEntity;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferedServiceJpaRepository extends JpaRepository<OfferedServiceEntity, UUID> {
  List<OfferedServiceEntity> findAllByCompanyId(UUID companyId);
}
