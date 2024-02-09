package puc.appointify.application.rest.handlers.category;

import puc.appointify.application.rest.handlers.category.contract.command.CreateCategoryCommand;
import puc.appointify.application.rest.handlers.category.contract.command.CreateCategoryCommandResponse;

import java.util.UUID;

public interface CategoryCommandHandler {
    CreateCategoryCommandResponse create(CreateCategoryCommand command);

    void deleteById(UUID id);
}
