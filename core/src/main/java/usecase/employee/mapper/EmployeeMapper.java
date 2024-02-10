package usecase.employee.mapper;

import usecase.employee.contract.command.CreatedEmployee;
import org.springframework.stereotype.Component;
import domain.entity.Employee;
import usecase.employee.contract.query.FoundEmployee;

@Component
public class EmployeeMapper {

    public CreatedEmployee employeeToCreateEmployeeCommandResponse(Employee employee) {
        return CreatedEmployee
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .companyId(employee.getCompany().getId())
                .build();
    }

    public FoundEmployee employeeToFindEmployeeQueryResponse(Employee employee) {
        return FoundEmployee
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .schedules(employee.getSchedules())
                .companyId(employee.getCompany().getId())
                .build();
    }
}
