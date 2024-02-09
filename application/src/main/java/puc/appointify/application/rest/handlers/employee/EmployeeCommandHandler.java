package puc.appointify.application.rest.handlers.employee;

import puc.appointify.application.rest.handlers.employee.contract.command.CreateEmployeeCommand;
import puc.appointify.application.rest.handlers.employee.contract.command.CreateEmployeeCommandResponse;

public interface EmployeeCommandHandler {
    CreateEmployeeCommandResponse create(CreateEmployeeCommand command);
}
