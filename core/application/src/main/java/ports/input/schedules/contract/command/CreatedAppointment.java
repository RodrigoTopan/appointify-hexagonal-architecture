package ports.input.schedules.contract.command;

import ports.input.schedules.contract.Company;
import ports.input.schedules.contract.Customer;
import ports.input.schedules.contract.Employee;
import ports.input.schedules.contract.Schedule;
import ports.input.schedules.contract.Service;

public record CreatedAppointment(
    Customer customer, Schedule schedule, Service service, Employee employee, Company company) {}
