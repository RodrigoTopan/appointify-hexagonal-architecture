package puc.appointify.application.rest.handlers.customer.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.customer.CustomerQueryHandler;
import puc.appointify.application.rest.handlers.customer.contract.query.FindCustomerQueryResponse;
import puc.appointify.application.rest.handlers.customer.mapper.CustomerMapper;
import ports.output.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerQueryHandlerImpl implements CustomerQueryHandler {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<FindCustomerQueryResponse> findAll() {
        var customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::customerToFindCustomerQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCustomerQueryResponse findById(UUID id) {
        var customer = customerRepository.findById(id);
        return customerMapper.customerToFindCustomerQueryResponse(customer);
    }

}
