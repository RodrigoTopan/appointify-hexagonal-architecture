package usecase.customer.mapper;

import usecase.customer.contract.command.CreateCustomerResult;
import usecase.customer.contract.query.FindCustomerResult;
import org.springframework.stereotype.Component;
import domain.entity.Customer;

@Component
public class CustomerMapper {

    public CreateCustomerResult customerToCreateCustomerCommandResponse(Customer customer) {
        return CreateCustomerResult
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }

    public FindCustomerResult customerToFindCustomerQueryResponse(Customer customer) {
        return FindCustomerResult
                .builder()
                .id(customer.getId())
                .userId(customer.getUser().getId())
                .build();
    }
}
