package ports.input;

import entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryInputPort {
    Category create(Category category);
    void delete(UUID categoryId);
    List<Category> findAll();
    Category findById(UUID id);
}
