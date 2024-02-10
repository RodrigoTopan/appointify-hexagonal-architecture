package usecase.schedules.contract.query;

import usecase.schedules.contract.Company;
import usecase.schedules.contract.Employee;
import usecase.schedules.contract.Schedule;
import usecase.schedules.contract.Service;


public record FoundAvailableSchedules(
        Schedule schedule,
        Service service,
        Employee employee,
        Company company
) {
}
