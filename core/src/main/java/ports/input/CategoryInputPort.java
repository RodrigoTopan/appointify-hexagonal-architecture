package ports.input;

import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreateCategoryResult;
import usecase.category.contract.query.FindCategoryResult;

import java.util.List;
import java.util.UUID;

public interface CategoryInputPort {
    CreateCategoryResult create(CreateCategory command);
    void deleteById(UUID id);
    List<FindCategoryResult> findAll();
    FindCategoryResult findById(UUID id);
}
