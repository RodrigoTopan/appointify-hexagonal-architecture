package ports.output.repository;

import entity.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
  Category save(Category category);

  List<Category> findAll();

  List<Category> findAllById(List<UUID> ids);

  Category findById(UUID id);

  void deleteById(UUID id);
}
