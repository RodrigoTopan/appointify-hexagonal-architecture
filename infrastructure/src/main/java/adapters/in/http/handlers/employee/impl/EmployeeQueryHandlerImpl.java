package adapters.in.http.handlers.employee.impl;

import adapters.in.http.handlers.employee.EmployeeQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import adapters.in.http.handlers.employee.mapper.EmployeeMapper;
import adapters.in.http.handlers.employee.contract.query.FindEmployeeQueryResponse;
import ports.output.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeQueryHandlerImpl implements EmployeeQueryHandler {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<FindEmployeeQueryResponse> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::employeeToFindEmployeeQueryResponse)
                .collect(Collectors.toList());
    }
}
