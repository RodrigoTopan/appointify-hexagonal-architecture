package ports.input.schedules.contract.command;

import java.util.Date;
import java.util.UUID;

public record CreateSchedule(
    Date scheduleStart, Date scheduleEnd, UUID offeredServiceId, UUID employeeId) {}
