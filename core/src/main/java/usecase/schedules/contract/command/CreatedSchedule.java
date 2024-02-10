package usecase.schedules.contract.command;

import java.util.Date;
import java.util.UUID;

public record CreatedSchedule(
        UUID id,
        Date scheduleStart,
        Date scheduleEnd,
        UUID offeredServiceId,
        UUID employeeId,

        boolean isAvailable,
        UUID customerAssigneeIo
) {
}
