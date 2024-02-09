package adapters.in.http.handlers.customer.impl;

import adapters.in.http.handlers.customer.CustomerCommandHandler;
import adapters.in.http.handlers.customer.contract.command.CreateCustomerCommand;
import adapters.in.http.handlers.customer.contract.command.CreateCustomerCommandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import adapters.in.http.handlers.customer.mapper.CustomerMapper;
import ports.output.repository.CustomerRepository;
import ports.output.repository.UserRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerCommandHandlerImpl implements CustomerCommandHandler {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    @Override
    public CreateCustomerCommandResponse create(CreateCustomerCommand command) {
        var user = userRepository.findById(command.getUserId());
        var customer = user.createCustomer();
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCreateCustomerCommandResponse(savedCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }

}
