package ports.input.schedules.contract.query;

import ports.input.schedules.contract.Company;
import ports.input.schedules.contract.Customer;
import ports.input.schedules.contract.Employee;
import ports.input.schedules.contract.Schedule;
import ports.input.schedules.contract.Service;

public record FoundAppointment(
    Customer customer, Schedule schedule, Service service, Employee employee, Company company) {}
