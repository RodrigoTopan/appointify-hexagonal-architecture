package usecase.employee;

import usecase.employee.contract.command.CreateEmployee;
import usecase.employee.contract.command.CreateEmployeeResult;
import usecase.employee.contract.query.FindEmployeeResult;
import usecase.employee.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.EmployeeInputPort;
import ports.output.repository.CompanyRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeManagerUseCase implements EmployeeInputPort {
    private final EmployeeMapper employeeMapper;
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    private final UserRepository userRepository;

    @Override
    public CreateEmployeeResult create(CreateEmployee command) {
        var company = companyRepository.findById(command.getCompanyId());
        var user = userRepository.findById(command.getUserId());
        var employee = company.createEmployee(user);
        var savedEmployeeEntity = employeeRepository.save(employee);
        return employeeMapper.employeeToCreateEmployeeCommandResponse(savedEmployeeEntity);
    }

    @Override
    public List<FindEmployeeResult> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::employeeToFindEmployeeQueryResponse)
                .collect(Collectors.toList());
    }
}
