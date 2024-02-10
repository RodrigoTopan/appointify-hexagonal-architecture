package ports.input.schedules.contract.query;

import ports.input.schedules.contract.Company;
import ports.input.schedules.contract.Employee;
import ports.input.schedules.contract.Schedule;
import ports.input.schedules.contract.Service;


public record FoundAvailableSchedules(
        Schedule schedule,
        Service service,
        Employee employee,
        Company company
) {
}
