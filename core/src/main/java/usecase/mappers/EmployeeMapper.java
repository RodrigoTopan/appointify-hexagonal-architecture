package usecase.mappers;

import domain.entity.Employee;
import ports.input.employee.contract.command.CreatedEmployee;
import ports.input.employee.contract.query.FoundEmployee;

public class EmployeeMapper {

  public CreatedEmployee employeeToCreateEmployeeCommandResponse(Employee employee) {
    return new CreatedEmployee(
        employee.getId(), employee.getUser().getId(), employee.getCompany().getId());
  }

  public FoundEmployee employeeToFindEmployeeQueryResponse(Employee employee) {
    return new FoundEmployee(
        employee.getId(),
        employee.getUser().getId(),
        employee.getCompany().getId(),
        employee.getSchedules());
  }
}
