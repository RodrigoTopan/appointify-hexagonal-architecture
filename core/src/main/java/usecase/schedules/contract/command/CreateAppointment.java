package usecase.schedules.contract.command;

import java.util.UUID;


public record CreateAppointment(
        UUID customerId,
        UUID scheduleId
) {
}
