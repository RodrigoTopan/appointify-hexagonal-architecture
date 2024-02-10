package usecase.employee.mapper;

import usecase.employee.contract.command.CreateEmployeeResult;
import org.springframework.stereotype.Component;
import domain.entity.Employee;
import usecase.employee.contract.query.FindEmployeeResult;

@Component
public class EmployeeMapper {

    public CreateEmployeeResult employeeToCreateEmployeeCommandResponse(Employee employee) {
        return CreateEmployeeResult
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .companyId(employee.getCompany().getId())
                .build();
    }

    public FindEmployeeResult employeeToFindEmployeeQueryResponse(Employee employee) {
        return FindEmployeeResult
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .schedules(employee.getSchedules())
                .companyId(employee.getCompany().getId())
                .build();
    }
}
