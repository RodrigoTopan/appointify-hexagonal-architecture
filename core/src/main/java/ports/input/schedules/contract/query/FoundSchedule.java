package ports.input.schedules.contract.query;

import java.util.Date;
import java.util.UUID;


public record FoundSchedule(
        UUID id,
        Date scheduleStart,
        Date scheduleEnd,
        UUID offeredServiceId,
        UUID employeeId,
        boolean isAvailable,
        UUID customerAssigneeId
) {
}
