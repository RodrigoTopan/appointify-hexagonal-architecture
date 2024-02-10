package usecase;

import ports.input.CategoryInputPort;
import ports.output.repository.CategoryRepository;
import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreateCategoryResult;
import usecase.category.contract.query.FindCategoryResult;
import usecase.category.mapper.CategoryMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CategoryManagerUseCase implements CategoryInputPort {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryManagerUseCase(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CreateCategoryResult create(CreateCategory command) {
        var category = categoryMapper.createCategoryCommandToCategory(command);
        var savedCategory = categoryRepository.save(category);
        return categoryMapper.categoryToCreateCategoryCommandResponse(savedCategory);
    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<FindCategoryResult> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToFindCategoryQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCategoryResult findById(UUID id) {
        var category = categoryRepository.findById(id);
        return categoryMapper.categoryToFindCategoryQueryResponse(category);
    }

}
