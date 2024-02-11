package usecase.mappers;

import domain.entity.Employee;
import java.util.UUID;
import ports.input.employee.contract.command.CreatedEmployee;
import ports.input.employee.contract.query.FoundEmployee;

public class EmployeeMapper {

  public CreatedEmployee employeeToCreateEmployeeCommandResponse(Employee employee) {
    return new CreatedEmployee(
        extractEmployeeId(employee), extractUserId(employee), extractCompanyId(employee));
  }

  public FoundEmployee employeeToFindEmployeeQueryResponse(Employee employee) {
    return new FoundEmployee(
        extractEmployeeId(employee),
        extractUserId(employee),
        extractCompanyId(employee),
        employee != null ? employee.getSchedules() : null);
  }

  private UUID extractEmployeeId(Employee employee) {
    return employee != null ? employee.getId() : null;
  }

  private UUID extractUserId(Employee employee) {
    return employee != null && employee.getUser() != null ? employee.getUser().getId() : null;
  }

  private UUID extractCompanyId(Employee employee) {
    return employee != null && employee.getCompany() != null ? employee.getCompany().getId() : null;
  }
}
