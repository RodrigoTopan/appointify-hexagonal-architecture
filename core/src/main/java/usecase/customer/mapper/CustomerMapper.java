package usecase.customer.mapper;

import usecase.customer.contract.command.CreatedCustomer;
import usecase.customer.contract.query.FoundCustomer;
import org.springframework.stereotype.Component;
import domain.entity.Customer;

@Component
public class CustomerMapper {

    public CreatedCustomer customerToCreateCustomerCommandResponse(Customer customer) {
        return CreatedCustomer
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }

    public FoundCustomer customerToFindCustomerQueryResponse(Customer customer) {
        return FoundCustomer
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }
}
