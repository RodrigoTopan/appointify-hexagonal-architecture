package ports.input;

import usecase.category.contract.command.CreateCategoryCommand;
import usecase.category.contract.command.CreateCategoryCommandResponse;
import usecase.category.contract.query.FindCategoryQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryInputPort {
    CreateCategoryCommandResponse create(CreateCategoryCommand command);
    void deleteById(UUID id);
    List<FindCategoryQueryResponse> findAll();
    FindCategoryQueryResponse findById(UUID id);
}
