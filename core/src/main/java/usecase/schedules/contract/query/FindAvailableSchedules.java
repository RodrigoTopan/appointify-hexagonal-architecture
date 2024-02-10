package usecase.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAvailableSchedules {
    private UUID companyId;
    private UUID offeredServiceId;
    private Date rangeStartDate;
    private Date rangeEndDate;
}
