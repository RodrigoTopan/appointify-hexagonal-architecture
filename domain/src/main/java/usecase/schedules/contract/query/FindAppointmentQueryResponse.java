package usecase.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import usecase.schedules.contract.CompanyDTO;
import usecase.schedules.contract.CustomerDTO;
import usecase.schedules.contract.EmployeeDTO;
import usecase.schedules.contract.ScheduleDTO;
import usecase.schedules.contract.ServiceDTO;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAppointmentQueryResponse {

    private CustomerDTO customer;
    private ScheduleDTO schedule;
    private ServiceDTO service;
    private EmployeeDTO employee;
    private CompanyDTO company;
}
