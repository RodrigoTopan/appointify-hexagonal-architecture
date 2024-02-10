package usecase.employee.contract.query;

import domain.entity.Schedule;

import java.util.List;
import java.util.UUID;

public record FoundEmployee(
        UUID id,
        UUID userId,
        UUID companyId,
        List<Schedule> schedules
) {}
