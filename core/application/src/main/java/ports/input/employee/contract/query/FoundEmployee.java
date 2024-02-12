package ports.input.employee.contract.query;

import entity.Schedule;
import java.util.List;
import java.util.UUID;

public record FoundEmployee(UUID id, UUID userId, UUID companyId, List<Schedule> schedules) {}
