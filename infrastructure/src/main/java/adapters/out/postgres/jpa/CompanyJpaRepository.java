package adapters.out.postgres.jpa;

import adapters.out.postgres.entity.CompanyEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, UUID> {}
