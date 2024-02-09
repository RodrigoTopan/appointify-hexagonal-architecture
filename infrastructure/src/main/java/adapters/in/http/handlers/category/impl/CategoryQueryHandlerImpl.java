package adapters.in.http.handlers.category.impl;

import adapters.in.http.handlers.category.CategoryQueryHandler;
import adapters.in.http.handlers.category.contract.query.FindCategoryQueryResponse;
import adapters.in.http.handlers.category.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryQueryHandlerImpl implements CategoryQueryHandler {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;


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
