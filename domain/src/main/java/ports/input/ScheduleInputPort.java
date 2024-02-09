package ports.input;

import usecase.schedules.contract.command.CreateAppointmentCommand;
import usecase.schedules.contract.command.CreateAppointmentCommandResponse;
import usecase.schedules.contract.command.CreateScheduleCommand;
import usecase.schedules.contract.command.CreateScheduleCommandResponse;
import usecase.schedules.contract.query.FindAppointmentQueryResponse;
import usecase.schedules.contract.query.FindAvailableSchedulesQuery;
import usecase.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import usecase.schedules.contract.query.FindCustomerAppointmentsQuery;
import usecase.schedules.contract.query.FindScheduleQueryResponse;

import java.util.List;

public interface ScheduleInputPort {
    CreateScheduleCommandResponse create(CreateScheduleCommand command);
    CreateAppointmentCommandResponse create(CreateAppointmentCommand command);
    List<FindScheduleQueryResponse> findAll();
    List<FindAppointmentQueryResponse> find(FindCustomerAppointmentsQuery query);
    List<FindAvailableSchedulesQueryResponse> find(FindAvailableSchedulesQuery query);
}
