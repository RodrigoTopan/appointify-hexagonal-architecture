package ports.input;

import usecase.employee.contract.command.CreateEmployee;
import usecase.employee.contract.command.CreateEmployeeResult;
import usecase.employee.contract.query.FindEmployeeResult;

import java.util.List;

public interface EmployeeInputPort {
    CreateEmployeeResult create(CreateEmployee command);
    List<FindEmployeeResult> findAll();
}
