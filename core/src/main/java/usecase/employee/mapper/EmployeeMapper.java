package usecase.employee.mapper;

import domain.entity.Employee;
import usecase.employee.contract.command.CreatedEmployee;
import usecase.employee.contract.query.FoundEmployee;

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
