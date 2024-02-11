package adapters.in.http.json.schedules;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CreateAppointmentRequest(@NotNull UUID customerId, @NotNull UUID scheduleId) {}
