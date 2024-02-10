package ports.input;

import usecase.employee.contract.command.CreateEmployee;
import usecase.employee.contract.command.CreatedEmployee;
import usecase.employee.contract.query.FoundEmployee;

import java.util.List;

public interface EmployeeInputPort {
    CreatedEmployee create(CreateEmployee command);
    List<FoundEmployee> findAll();
}
