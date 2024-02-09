package adapters.out.jpa;

import adapters.out.entity.OfferedServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferedServiceJpaRepository extends JpaRepository<OfferedServiceEntity, UUID> {
    List<OfferedServiceEntity> findAllByCompanyId(UUID companyId);
}
