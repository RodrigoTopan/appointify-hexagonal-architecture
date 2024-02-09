package adapters.in.http.handlers.schedules.impl;

import adapters.in.http.handlers.schedules.ScheduleCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import adapters.in.http.handlers.schedules.contract.command.CreateAppointmentCommand;
import adapters.in.http.handlers.schedules.contract.command.CreateAppointmentCommandResponse;
import adapters.in.http.handlers.schedules.mapper.ScheduleMapper;
import adapters.in.http.handlers.schedules.contract.command.CreateScheduleCommand;
import adapters.in.http.handlers.schedules.contract.command.CreateScheduleCommandResponse;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.OfferedServiceRepository;
import ports.output.repository.ScheduleRepository;

@Component
@RequiredArgsConstructor
public class ScheduleCommandHandlerImpl implements ScheduleCommandHandler {
    private final ScheduleMapper scheduleMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final OfferedServiceRepository offeredServiceRepository;
    private final ScheduleRepository scheduleRepository;

    @Override
    public CreateScheduleCommandResponse create(CreateScheduleCommand command) {
        var employee = employeeRepository.findById(command.getEmployeeId());
        //var employeeSchedules = scheduleRepository.findByEmployeeId(command.getEmployeeId());
        //employee.loadSchedules(employeeSchedules);

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

}