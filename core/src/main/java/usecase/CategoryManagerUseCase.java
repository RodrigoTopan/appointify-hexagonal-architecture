package usecase;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import ports.input.CategoryInputPort;
import ports.output.repository.CategoryRepository;
import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreatedCategory;
import usecase.category.contract.query.FoundCategory;
import usecase.category.mapper.CategoryMapper;

public class CategoryManagerUseCase implements CategoryInputPort {
  private final CategoryMapper categoryMapper;
  private final CategoryRepository categoryRepository;

  public CategoryManagerUseCase(
      CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
    this.categoryMapper = categoryMapper;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public CreatedCategory create(CreateCategory command) {
    var category = categoryMapper.createCategoryCommandToCategory(command);
    var savedCategory = categoryRepository.save(category);
    return categoryMapper.categoryToCreateCategoryCommandResponse(savedCategory);
  }

  @Override
  public void deleteById(UUID id) {
    categoryRepository.deleteById(id);
  }

  @Override
  public List<FoundCategory> findAll() {
    return categoryRepository
        .findAll()
        .stream()
        .map(categoryMapper::categoryToFindCategoryQueryResponse)
        .collect(Collectors.toList());
  }

  @Override
  public FoundCategory findById(UUID id) {
    var category = categoryRepository.findById(id);
    return categoryMapper.categoryToFindCategoryQueryResponse(category);
  }
}
