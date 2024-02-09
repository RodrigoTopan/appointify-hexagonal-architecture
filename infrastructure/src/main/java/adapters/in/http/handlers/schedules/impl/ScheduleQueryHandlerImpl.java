package adapters.in.http.handlers.schedules.impl;

import adapters.in.http.handlers.schedules.ScheduleQueryHandler;
import adapters.in.http.handlers.schedules.contract.query.FindAppointmentQueryResponse;
import adapters.in.http.handlers.schedules.contract.query.FindAvailableSchedulesQuery;
import adapters.in.http.handlers.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import adapters.in.http.handlers.schedules.contract.query.FindCustomerAppointmentsQuery;
import adapters.in.http.handlers.schedules.contract.query.FindScheduleQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import adapters.in.http.handlers.schedules.mapper.ScheduleMapper;
import ports.output.repository.ScheduleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduleQueryHandlerImpl implements ScheduleQueryHandler {
    private final ScheduleMapper scheduleMapper;
    private final ScheduleRepository scheduleRepository;

    @Override
    public List<FindScheduleQueryResponse> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(scheduleMapper::scheduleToFindScheduleQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FindAppointmentQueryResponse> find(FindCustomerAppointmentsQuery query) {
        return scheduleRepository.findByCustomerId(query.getCustomerId())
                .stream()
                .map(scheduleMapper::scheduleToFindAppointmentQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FindAvailableSchedulesQueryResponse> find(FindAvailableSchedulesQuery query) {
        return scheduleRepository
                .findAllByAvailableStatusAndCompanyIdAndDate(query.getCompanyId(), query.getRangeStartDate(), query.getRangeEndDate())
                .stream()
                .map(scheduleMapper::scheduleToFindAvailableSchedulesQueryResponse)
                .collect(Collectors.toList());
    }
}
