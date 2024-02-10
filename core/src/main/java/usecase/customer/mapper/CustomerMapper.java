package usecase.customer.mapper;

import usecase.customer.contract.command.CreatedCustomer;
import usecase.customer.contract.query.FoundCustomer;

import domain.entity.Customer;


public class CustomerMapper {

    public CreatedCustomer customerToCreateCustomerCommandResponse(Customer customer) {
        return new CreatedCustomer(customer.getId(), customer.getUser().getId());
    }

    public FoundCustomer customerToFindCustomerQueryResponse(Customer customer) {
        return new FoundCustomer(
                customer.getId(),
                customer.getUser().getId()
        );
    }
}
