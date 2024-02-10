package usecase.employee.mapper;

import usecase.employee.contract.command.CreatedEmployee;
import org.springframework.stereotype.Component;
import domain.entity.Employee;
import usecase.employee.contract.query.FoundEmployee;

@Component
public class EmployeeMapper {

    public CreatedEmployee employeeToCreateEmployeeCommandResponse(Employee employee) {
        return new CreatedEmployee(
                employee.getId(),
                employee.getUser().getId(),
                employee.getCompany().getId()
        );
    }

    public FoundEmployee employeeToFindEmployeeQueryResponse(Employee employee) {
        return new FoundEmployee(
                employee.getId(),
                employee.getUser().getId(),
                employee.getCompany().getId(),
                employee.getSchedules()
        );
    }
}
