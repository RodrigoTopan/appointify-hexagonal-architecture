package ports.input;

import java.util.List;
import java.util.UUID;
import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreatedCategory;
import usecase.category.contract.query.FoundCategory;

public interface CategoryInputPort {
  CreatedCategory create(CreateCategory command);

  void deleteById(UUID id);

  List<FoundCategory> findAll();

  FoundCategory findById(UUID id);
}
