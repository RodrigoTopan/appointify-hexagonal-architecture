package adapters.out.jpa;

import adapters.out.entity.OfferedServiceEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferedServiceJpaRepository extends JpaRepository<OfferedServiceEntity, UUID> {
  List<OfferedServiceEntity> findAllByCompanyId(UUID companyId);
}
