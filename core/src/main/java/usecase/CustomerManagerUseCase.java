package usecase;

import usecase.customer.contract.command.CreateCustomer;
import usecase.customer.contract.command.CreatedCustomer;
import usecase.customer.contract.query.FoundCustomer;
import usecase.customer.mapper.CustomerMapper;
import ports.input.CustomerInputPort;
import ports.output.repository.CustomerRepository;
import ports.output.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerManagerUseCase implements CustomerInputPort {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public CustomerManagerUseCase(CustomerMapper customerMapper, CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CreatedCustomer create(CreateCustomer command) {
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
    public List<FoundCustomer> findAll() {
        var customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::customerToFindCustomerQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FoundCustomer findById(UUID id) {
        var customer = customerRepository.findById(id);
        return customerMapper.customerToFindCustomerQueryResponse(customer);
    }

}
