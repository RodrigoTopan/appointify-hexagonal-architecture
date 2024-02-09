package usecase.category;

import usecase.category.contract.query.FindCategoryQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.CategoryInputPort;
import usecase.category.contract.command.CreateCategoryCommand;
import usecase.category.contract.command.CreateCategoryCommandResponse;
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
    public CreateCategoryCommandResponse create(CreateCategoryCommand command) {
        var category = categoryMapper.createCategoryCommandToCategory(command);
        var savedCategory = categoryRepository.save(category);
        return categoryMapper.categoryToCreateCategoryCommandResponse(savedCategory);
    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<FindCategoryQueryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToFindCategoryQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCategoryQueryResponse findById(UUID id) {
        var category = categoryRepository.findById(id);
        return categoryMapper.categoryToFindCategoryQueryResponse(category);
    }

}
