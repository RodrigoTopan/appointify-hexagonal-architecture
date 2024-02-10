package usecase.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import usecase.schedules.contract.Company;
import usecase.schedules.contract.Customer;
import usecase.schedules.contract.Employee;
import usecase.schedules.contract.Schedule;
import usecase.schedules.contract.Service;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAppointmentQueryResult {

    private Customer customer;
    private Schedule schedule;
    private Service service;
    private Employee employee;
    private Company company;
}
