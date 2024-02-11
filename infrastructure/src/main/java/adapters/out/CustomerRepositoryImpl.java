package adapters.out;

import adapters.out.entity.CustomerEntity;
import adapters.out.jpa.CustomerJpaRepository;
import adapters.out.jpa.ScheduleJpaRepository;
import adapters.out.mapper.CustomerDataAccessMapper;
import domain.entity.Customer;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.CustomerRepository;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
  private final CustomerJpaRepository customerJpaRepository;
  private final ScheduleJpaRepository scheduleJpaRepository;

  @Override
  public Customer save(Customer customer) {
    var entity = CustomerDataAccessMapper.toEntity(customer);
    var savedEntity = customerJpaRepository.save(entity);
    return CustomerDataAccessMapper.toDomain(savedEntity);
  }

  @Override
  public List<Customer> findAll() {
    List<CustomerEntity> customersEntities = customerJpaRepository.findAll();
    return customersEntities.stream()
        .map(CustomerDataAccessMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Customer findById(UUID id) {
    var optionalCustomerEntity = customerJpaRepository.findById(id);
    if (optionalCustomerEntity.isEmpty()) return null;
    var customerEntity = optionalCustomerEntity.get();
    var scheduleEntities = scheduleJpaRepository.findByCustomerId(customerEntity.getId());
    customerEntity.setSchedules(scheduleEntities);
    return CustomerDataAccessMapper.toDomain(customerEntity);
  }

  @Override
  public void deleteById(UUID id) {
    customerJpaRepository.deleteById(id);
  }
}
