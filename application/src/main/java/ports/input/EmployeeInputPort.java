package ports.input;

import java.util.List;
import ports.input.employee.contract.command.CreateEmployee;
import ports.input.employee.contract.command.CreatedEmployee;
import ports.input.employee.contract.query.FoundEmployee;

public interface EmployeeInputPort {
  CreatedEmployee create(CreateEmployee command);

  List<FoundEmployee> findAll();
}
