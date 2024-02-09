package adapters.in.http.handlers.customer.mapper;

import adapters.in.http.handlers.customer.contract.command.CreateCustomerCommandResponse;
import adapters.in.http.handlers.customer.contract.query.FindCustomerQueryResponse;
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
