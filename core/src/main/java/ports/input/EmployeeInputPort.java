package ports.input;

import usecase.employee.contract.command.CreateEmployeeCommand;
import usecase.employee.contract.command.CreateEmployeeCommandResponse;
import usecase.employee.contract.query.FindEmployeeQueryResponse;

import java.util.List;

public interface EmployeeInputPort {
    CreateEmployeeCommandResponse create(CreateEmployeeCommand command);
    List<FindEmployeeQueryResponse> findAll();
}
