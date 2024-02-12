package adapters.out.postgres.jpa;

import adapters.out.postgres.entity.CustomerEntity;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {}
