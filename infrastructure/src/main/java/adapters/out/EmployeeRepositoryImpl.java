package adapters.out;

import domain.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.EmployeeRepository;
import adapters.out.entity.EmployeeEntity;
import adapters.out.jpa.EmployeeJpaRepository;
import adapters.out.mapper.EmployeeDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return entities
                .stream()
                .map(EmployeeDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(UUID id) {
        var entity = employeeJpaRepository.findById(id).orElseThrow();
        return EmployeeDataAccessMapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        employeeJpaRepository.deleteById(id);
    }
}