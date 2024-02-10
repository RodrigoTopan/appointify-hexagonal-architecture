package usecase.customer;

import usecase.customer.contract.command.CreateCustomerCommand;
import usecase.customer.contract.command.CreateCustomerCommandResponse;
import usecase.customer.contract.query.FindCustomerQueryResponse;
import usecase.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.CustomerInputPort;
import ports.output.repository.CustomerRepository;
import ports.output.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerManagerUseCase implements CustomerInputPort {
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
