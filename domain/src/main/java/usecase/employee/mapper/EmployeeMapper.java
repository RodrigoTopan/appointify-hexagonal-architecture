package usecase.employee.mapper;

import usecase.employee.contract.command.CreateEmployeeCommandResponse;
import org.springframework.stereotype.Component;
import entity.Employee;
import usecase.employee.contract.query.FindEmployeeQueryResponse;

@Component
public class EmployeeMapper {

    public CreateEmployeeCommandResponse employeeToCreateEmployeeCommandResponse(Employee employee) {
        return CreateEmployeeCommandResponse
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .companyId(employee.getCompany().getId())
                .build();
    }

    public FindEmployeeQueryResponse employeeToFindEmployeeQueryResponse(Employee employee) {
        return FindEmployeeQueryResponse
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .schedules(employee.getSchedules())
                .companyId(employee.getCompany().getId())
                .build();
    }
}
