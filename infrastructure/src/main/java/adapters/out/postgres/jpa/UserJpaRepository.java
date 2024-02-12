package adapters.out.postgres.jpa;

import adapters.out.postgres.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
  UserEntity findByUsername(String username);
}
