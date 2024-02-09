package adapters.in.http.handlers.customer.impl;

import adapters.in.http.handlers.customer.CustomerQueryHandler;
import adapters.in.http.handlers.customer.contract.query.FindCustomerQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import adapters.in.http.handlers.customer.mapper.CustomerMapper;
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
