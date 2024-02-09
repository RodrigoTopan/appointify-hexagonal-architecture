package usecase.schedules;

import usecase.schedules.contract.query.FindAppointmentQueryResponse;
import usecase.schedules.contract.query.FindAvailableSchedulesQuery;
import usecase.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import usecase.schedules.contract.query.FindCustomerAppointmentsQuery;
import usecase.schedules.contract.query.FindScheduleQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import usecase.schedules.contract.command.CreateAppointmentCommand;
import usecase.schedules.contract.command.CreateAppointmentCommandResponse;
import usecase.schedules.mapper.ScheduleMapper;
import usecase.schedules.contract.command.CreateScheduleCommand;
import usecase.schedules.contract.command.CreateScheduleCommandResponse;
import ports.input.ScheduleInputPort;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.OfferedServiceRepository;
import ports.output.repository.ScheduleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduleManagerUseCase implements ScheduleInputPort {
    private final ScheduleMapper scheduleMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final OfferedServiceRepository offeredServiceRepository;
    private final ScheduleRepository scheduleRepository;

    @Override
    public CreateScheduleCommandResponse create(CreateScheduleCommand command) {
        var employee = employeeRepository.findById(command.getEmployeeId());

        var offeredService = offeredServiceRepository.findById(command.getOfferedServiceId());

        var schedule = employee.addSchedule(
                command.getScheduleStart(),
                command.getScheduleEnd(),
                offeredService);

        var savedSchedule = scheduleRepository.save(schedule);
        return scheduleMapper.scheduleToCreateScheduleCommandResponse(savedSchedule);
    }

    @Override
    public CreateAppointmentCommandResponse create(CreateAppointmentCommand command) {
        var customer = customerRepository.findById(command.getCustomerId());
        var schedule = scheduleRepository.findById(command.getScheduleId());
        var assignedSchedule = customer.assignAppointment(schedule);
        var savedAssignedSchedule = scheduleRepository.save(assignedSchedule);
        return scheduleMapper.scheduleToCreateAppointmentCommandResponse(savedAssignedSchedule);
    }

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