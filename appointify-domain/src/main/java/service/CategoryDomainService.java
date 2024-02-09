package service;

import entity.Category;
import ports.input.CategoryInputPort;
import ports.output.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

public class CategoryDomainService implements CategoryInputPort {
    private final CategoryRepository categoryRepository;

    public CategoryDomainService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void delete(UUID categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(UUID id) {
        return this.categoryRepository.findById(id);
    }
}
