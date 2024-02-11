package adapters.in.http.json.schedules;

import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public record CreateScheduleRequest(
    @NotNull Date scheduleStart,
    @NotNull Date scheduleEnd,
    @NotNull UUID offeredServiceId,
    @NotNull UUID employeeId) {}
