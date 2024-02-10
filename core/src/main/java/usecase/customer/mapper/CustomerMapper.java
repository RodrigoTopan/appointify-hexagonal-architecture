package usecase.customer.mapper;

import domain.entity.Customer;
import usecase.customer.contract.command.CreatedCustomer;
import usecase.customer.contract.query.FoundCustomer;

public class CustomerMapper {

  public CreatedCustomer customerToCreateCustomerCommandResponse(Customer customer) {
    return new CreatedCustomer(customer.getId(), customer.getUser().getId());
  }

  public FoundCustomer customerToFindCustomerQueryResponse(Customer customer) {
    return new FoundCustomer(customer.getId(), customer.getUser().getId());
  }
}
