package adapters.in.http.handlers.schedules;

import adapters.in.http.handlers.schedules.contract.query.FindAppointmentQueryResponse;
import adapters.in.http.handlers.schedules.contract.query.FindAvailableSchedulesQuery;
import adapters.in.http.handlers.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import adapters.in.http.handlers.schedules.contract.query.FindCustomerAppointmentsQuery;
import adapters.in.http.handlers.schedules.contract.query.FindScheduleQueryResponse;

import java.util.List;

public interface ScheduleQueryHandler {
    List<FindScheduleQueryResponse> findAll();

    List<FindAppointmentQueryResponse> find(FindCustomerAppointmentsQuery query);

    List<FindAvailableSchedulesQueryResponse> find(FindAvailableSchedulesQuery query);
}
