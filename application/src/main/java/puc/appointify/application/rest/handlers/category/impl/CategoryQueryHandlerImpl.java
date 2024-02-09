package puc.appointify.application.rest.handlers.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.category.contract.query.FindCategoryQueryResponse;
import puc.appointify.application.rest.handlers.category.mapper.CategoryMapper;
import ports.output.repository.CategoryRepository;
import puc.appointify.application.rest.handlers.category.CategoryQueryHandler;

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
