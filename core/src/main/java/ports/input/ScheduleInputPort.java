package ports.input;

import usecase.schedules.contract.command.CreateAppointment;
import usecase.schedules.contract.command.CreateAppointmentResult;
import usecase.schedules.contract.command.CreateSchedule;
import usecase.schedules.contract.command.CreateScheduleResult;
import usecase.schedules.contract.query.FindAppointmentQueryResult;
import usecase.schedules.contract.query.FindAvailableSchedules;
import usecase.schedules.contract.query.FindAvailableSchedulesResult;
import usecase.schedules.contract.query.FindCustomerAppointments;
import usecase.schedules.contract.query.FindScheduleResult;

import java.util.List;

public interface ScheduleInputPort {
    CreateScheduleResult create(CreateSchedule command);
    CreateAppointmentResult create(CreateAppointment command);
    List<FindScheduleResult> findAll();
    List<FindAppointmentQueryResult> find(FindCustomerAppointments query);
    List<FindAvailableSchedulesResult> find(FindAvailableSchedules query);
}
