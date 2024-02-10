package ports.input;

import java.util.List;
import java.util.UUID;
import ports.input.category.contract.command.CreateCategory;
import ports.input.category.contract.command.CreatedCategory;
import ports.input.category.contract.query.FoundCategory;

public interface CategoryInputPort {
  CreatedCategory create(CreateCategory command);

  void deleteById(UUID id);

  List<FoundCategory> findAll();

  FoundCategory findById(UUID id);
}
