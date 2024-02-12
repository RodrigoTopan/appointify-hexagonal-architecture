package usecase.mappers;

import entity.Customer;
import java.util.UUID;
import ports.input.customer.contract.command.CreatedCustomer;
import ports.input.customer.contract.query.FoundCustomer;

public class CustomerMapper {

  public CreatedCustomer customerToCreateCustomerCommandResponse(Customer customer) {
    return new CreatedCustomer(extractCustomerId(customer), extractUserId(customer));
  }

  public FoundCustomer customerToFindCustomerQueryResponse(Customer customer) {
    return new FoundCustomer(extractCustomerId(customer), extractUserId(customer));
  }

  private UUID extractCustomerId(Customer customer) {
    return customer != null ? customer.getId() : null;
  }

  private UUID extractUserId(Customer customer) {
    return customer != null && customer.getUser() != null ? customer.getUser().getId() : null;
  }
}
