package ports.input;

import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreatedCategory;
import usecase.category.contract.query.FoundCategory;

import java.util.List;
import java.util.UUID;

public interface CategoryInputPort {
    CreatedCategory create(CreateCategory command);
    void deleteById(UUID id);
    List<FoundCategory> findAll();
    FoundCategory findById(UUID id);
}
