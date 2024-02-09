package adapters.in.http.handlers.schedules;

import adapters.in.http.handlers.schedules.contract.command.CreateAppointmentCommand;
import adapters.in.http.handlers.schedules.contract.command.CreateAppointmentCommandResponse;
import adapters.in.http.handlers.schedules.contract.command.CreateScheduleCommand;
import adapters.in.http.handlers.schedules.contract.command.CreateScheduleCommandResponse;

public interface ScheduleCommandHandler {
    CreateScheduleCommandResponse create(CreateScheduleCommand command);
    CreateAppointmentCommandResponse create(CreateAppointmentCommand command);
}
