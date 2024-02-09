package puc.appointify.application.rest.handlers.customer.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.customer.CustomerCommandHandler;
import puc.appointify.application.rest.handlers.customer.contract.command.CreateCustomerCommand;
import puc.appointify.application.rest.handlers.customer.contract.command.CreateCustomerCommandResponse;
import puc.appointify.application.rest.handlers.customer.mapper.CustomerMapper;
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
