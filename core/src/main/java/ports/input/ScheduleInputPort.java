package ports.input;

import usecase.schedules.contract.command.CreateAppointment;
import usecase.schedules.contract.command.CreatedAppointment;
import usecase.schedules.contract.command.CreateSchedule;
import usecase.schedules.contract.command.CreatedSchedule;
import usecase.schedules.contract.query.FoundAppointment;
import usecase.schedules.contract.query.FindAvailableSchedules;
import usecase.schedules.contract.query.FoundAvailableSchedules;
import usecase.schedules.contract.query.FindCustomerAppointments;
import usecase.schedules.contract.query.FoundSchedule;

import java.util.List;

public interface ScheduleInputPort {
    CreatedSchedule create(CreateSchedule command);
    CreatedAppointment create(CreateAppointment command);
    List<FoundSchedule> findAll();
    List<FoundAppointment> find(FindCustomerAppointments query);
    List<FoundAvailableSchedules> find(FindAvailableSchedules query);
}
