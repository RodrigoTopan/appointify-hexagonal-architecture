package puc.appointify.application.rest.handlers.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.CategoryInputPort;
import puc.appointify.application.rest.handlers.category.CategoryCommandHandler;
import puc.appointify.application.rest.handlers.category.contract.command.CreateCategoryCommand;
import puc.appointify.application.rest.handlers.category.contract.command.CreateCategoryCommandResponse;
import puc.appointify.application.rest.handlers.category.mapper.CategoryMapper;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryCommandHandlerImpl implements CategoryCommandHandler {
    private final CategoryMapper categoryMapper;
    private final CategoryInputPort categoryInputPort;

    @Override
    public CreateCategoryCommandResponse create(CreateCategoryCommand command) {
        var category = categoryMapper.createCategoryCommandToCategory(command);
        var savedCategory = categoryInputPort.create(category);
        return categoryMapper.categoryToCreateCategoryCommandResponse(savedCategory);
    }

    @Override
    public void deleteById(UUID id) {
        categoryInputPort.delete(id);
    }

}
