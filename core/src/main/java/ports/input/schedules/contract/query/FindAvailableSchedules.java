package ports.input.schedules.contract.query;

import java.util.Date;
import java.util.UUID;

public record FindAvailableSchedules(
        UUID companyId,
        UUID offeredServiceId,
        Date rangeStartDate,
        Date rangeEndDate
) {
}
