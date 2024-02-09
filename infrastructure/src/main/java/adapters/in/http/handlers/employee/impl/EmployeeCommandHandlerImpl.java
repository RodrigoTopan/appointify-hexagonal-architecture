package adapters.in.http.handlers.employee.impl;

import adapters.in.http.handlers.employee.EmployeeCommandHandler;
import adapters.in.http.handlers.employee.contract.command.CreateEmployeeCommand;
import adapters.in.http.handlers.employee.contract.command.CreateEmployeeCommandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.UserRepository;
import adapters.in.http.handlers.employee.mapper.EmployeeMapper;
import ports.output.repository.CompanyRepository;

@Component
@RequiredArgsConstructor
public class EmployeeCommandHandlerImpl implements EmployeeCommandHandler {
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
}
