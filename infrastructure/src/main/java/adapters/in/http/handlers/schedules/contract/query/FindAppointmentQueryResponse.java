package adapters.in.http.handlers.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import adapters.in.http.handlers.schedules.contract.CompanyDTO;
import adapters.in.http.handlers.schedules.contract.CustomerDTO;
import adapters.in.http.handlers.schedules.contract.EmployeeDTO;
import adapters.in.http.handlers.schedules.contract.ScheduleDTO;
import adapters.in.http.handlers.schedules.contract.ServiceDTO;

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
