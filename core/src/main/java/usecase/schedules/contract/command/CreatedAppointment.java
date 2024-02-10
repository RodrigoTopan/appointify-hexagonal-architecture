package usecase.schedules.contract.command;

import usecase.schedules.contract.Company;
import usecase.schedules.contract.Customer;
import usecase.schedules.contract.Employee;
import usecase.schedules.contract.Schedule;
import usecase.schedules.contract.Service;

public record CreatedAppointment (
     Customer customer,
     Schedule schedule,
     Service service,
     Employee employee,
     Company company
){}
