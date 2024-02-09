package puc.appointify.application.rest.handlers.schedules.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import puc.appointify.application.rest.handlers.schedules.contract.CompanyDTO;
import puc.appointify.application.rest.handlers.schedules.contract.CustomerDTO;
import puc.appointify.application.rest.handlers.schedules.contract.EmployeeDTO;
import puc.appointify.application.rest.handlers.schedules.contract.ScheduleDTO;
import puc.appointify.application.rest.handlers.schedules.contract.ServiceDTO;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentCommandResponse {
    private CustomerDTO customer;
    private ScheduleDTO schedule;
    private ServiceDTO service;
    private EmployeeDTO employee;
    private CompanyDTO company;
}
