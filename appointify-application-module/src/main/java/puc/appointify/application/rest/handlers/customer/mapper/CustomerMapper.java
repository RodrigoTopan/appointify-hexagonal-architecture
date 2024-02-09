package puc.appointify.application.rest.handlers.customer.mapper;

import org.springframework.stereotype.Component;
import entity.Customer;
import puc.appointify.application.rest.handlers.customer.contract.command.CreateCustomerCommandResponse;
import puc.appointify.application.rest.handlers.customer.contract.query.FindCustomerQueryResponse;

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
