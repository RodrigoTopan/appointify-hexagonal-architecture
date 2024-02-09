package usecase.employee;

import usecase.employee.contract.command.CreateEmployeeCommand;
import usecase.employee.contract.command.CreateEmployeeCommandResponse;
import usecase.employee.contract.query.FindEmployeeQueryResponse;
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
    public CreateEmployeeCommandResponse create(CreateEmployeeCommand command) {
        var company = companyRepository.findById(command.getCompanyId());
        var user = userRepository.findById(command.getUserId());
        var employee = company.createEmployee(user);
        var savedEmployeeEntity = employeeRepository.save(employee);
        return employeeMapper.employeeToCreateEmployeeCommandResponse(savedEmployeeEntity);
    }

    @Override
    public List<FindEmployeeQueryResponse> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::employeeToFindEmployeeQueryResponse)
                .collect(Collectors.toList());
    }
}
