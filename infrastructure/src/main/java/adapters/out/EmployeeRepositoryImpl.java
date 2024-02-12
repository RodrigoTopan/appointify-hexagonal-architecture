package adapters.out;

import adapters.out.postgres.entity.EmployeeEntity;
import adapters.out.postgres.jpa.EmployeeJpaRepository;
import adapters.out.postgres.mapper.EmployeeDataAccessMapper;
import entity.Employee;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.EmployeeRepository;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
  private final EmployeeJpaRepository employeeJpaRepository;

  @Override
  public Employee save(Employee employee) {
    var employeeEntity = EmployeeDataAccessMapper.toEntity(employee);
    var savedEntity = employeeJpaRepository.save(employeeEntity);
    return EmployeeDataAccessMapper.toDomain(savedEntity);
  }

  @Override
  public List<Employee> findAll() {
    List<EmployeeEntity> entities = employeeJpaRepository.findAll();
    return entities.stream().map(EmployeeDataAccessMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public Employee findById(UUID id) {
    var entity = employeeJpaRepository.findById(id);
    return entity.map(EmployeeDataAccessMapper::toDomain).orElse(null);
  }

  @Override
  public void deleteById(UUID id) {
    employeeJpaRepository.deleteById(id);
  }
}
