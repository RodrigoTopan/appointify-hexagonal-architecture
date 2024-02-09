package adapters.in.http.handlers.employee;

import adapters.in.http.handlers.employee.contract.command.CreateEmployeeCommand;
import adapters.in.http.handlers.employee.contract.command.CreateEmployeeCommandResponse;

public interface EmployeeCommandHandler {
    CreateEmployeeCommandResponse create(CreateEmployeeCommand command);
}
