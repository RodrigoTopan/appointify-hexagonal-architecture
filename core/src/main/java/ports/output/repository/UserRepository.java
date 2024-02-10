package ports.output.repository;

import domain.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    User findById(UUID id);

    User findByUsername(String username);

    void deleteById(UUID id);
}
