package usecase.category;

import usecase.category.contract.query.FindCategoryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.CategoryInputPort;
import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreateCategoryResult;
import usecase.category.mapper.CategoryMapper;
import ports.output.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryManagerUseCase implements CategoryInputPort {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

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
