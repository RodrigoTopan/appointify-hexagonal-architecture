package puc.appointify.application.rest.handlers.schedules;

import puc.appointify.application.rest.handlers.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.application.rest.handlers.schedules.contract.query.FindAvailableSchedulesQuery;
import puc.appointify.application.rest.handlers.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import puc.appointify.application.rest.handlers.schedules.contract.query.FindCustomerAppointmentsQuery;
import puc.appointify.application.rest.handlers.schedules.contract.query.FindScheduleQueryResponse;

import java.util.List;

public interface ScheduleQueryHandler {
    List<FindScheduleQueryResponse> findAll();

    List<FindAppointmentQueryResponse> find(FindCustomerAppointmentsQuery query);

    List<FindAvailableSchedulesQueryResponse> find(FindAvailableSchedulesQuery query);
}
