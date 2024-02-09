package puc.appointify.application.rest.handlers.employee.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.employee.EmployeeQueryHandler;
import puc.appointify.application.rest.handlers.employee.mapper.EmployeeMapper;
import puc.appointify.application.rest.handlers.employee.contract.query.FindEmployeeQueryResponse;
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
