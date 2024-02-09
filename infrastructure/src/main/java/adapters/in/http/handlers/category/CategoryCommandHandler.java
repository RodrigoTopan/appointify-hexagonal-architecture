package adapters.in.http.handlers.category;

import adapters.in.http.handlers.category.contract.command.CreateCategoryCommand;
import adapters.in.http.handlers.category.contract.command.CreateCategoryCommandResponse;

import java.util.UUID;

public interface CategoryCommandHandler {
    CreateCategoryCommandResponse create(CreateCategoryCommand command);

    void deleteById(UUID id);
}
