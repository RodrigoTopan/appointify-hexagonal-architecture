package usecase.customer.mapper;

import usecase.customer.contract.command.CreateCustomerCommandResponse;
import usecase.customer.contract.query.FindCustomerQueryResponse;
import org.springframework.stereotype.Component;
import entity.Customer;

@Component
public class CustomerMapper {

    public CreateCustomerCommandResponse customerToCreateCustomerCommandResponse(Customer customer) {
        return CreateCustomerCommandResponse
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }

    public FindCustomerQueryResponse customerToFindCustomerQueryResponse(Customer customer) {
        return FindCustomerQueryResponse
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }
}
