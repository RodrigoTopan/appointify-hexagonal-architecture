package puc.appointify.application.rest.handlers.schedules;

import puc.appointify.application.rest.handlers.schedules.contract.command.CreateAppointmentCommand;
import puc.appointify.application.rest.handlers.schedules.contract.command.CreateAppointmentCommandResponse;
import puc.appointify.application.rest.handlers.schedules.contract.command.CreateScheduleCommand;
import puc.appointify.application.rest.handlers.schedules.contract.command.CreateScheduleCommandResponse;

public interface ScheduleCommandHandler {
    CreateScheduleCommandResponse create(CreateScheduleCommand command);
    CreateAppointmentCommandResponse create(CreateAppointmentCommand command);
}
