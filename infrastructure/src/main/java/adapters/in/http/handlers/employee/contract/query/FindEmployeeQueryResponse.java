package adapters.in.http.handlers.employee.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import entity.Schedule;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindEmployeeQueryResponse {

    private UUID id;
    private UUID userId;
    private UUID companyId;
    private List<Schedule> schedules;
}
