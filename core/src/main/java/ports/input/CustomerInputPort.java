package ports.input;

import java.util.List;
import java.util.UUID;
import ports.input.customer.contract.command.CreateCustomer;
import ports.input.customer.contract.command.CreatedCustomer;
import ports.input.customer.contract.query.FoundCustomer;

public interface CustomerInputPort {
  CreatedCustomer create(CreateCustomer command);

  void deleteById(UUID id);

  List<FoundCustomer> findAll();

  FoundCustomer findById(UUID id);
}
