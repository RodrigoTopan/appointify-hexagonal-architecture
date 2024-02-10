package usecase;

import usecase.schedules.contract.query.FoundAppointment;
import usecase.schedules.contract.query.FindAvailableSchedules;
import usecase.schedules.contract.query.FoundAvailableSchedules;
import usecase.schedules.contract.query.FindCustomerAppointments;
import usecase.schedules.contract.query.FoundSchedule;
import usecase.schedules.contract.command.CreateAppointment;
import usecase.schedules.contract.command.CreatedAppointment;
import usecase.schedules.mapper.ScheduleMapper;
import usecase.schedules.contract.command.CreateSchedule;
import usecase.schedules.contract.command.CreatedSchedule;
import ports.input.ScheduleInputPort;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.OfferedServiceRepository;
import ports.output.repository.ScheduleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleManagerUseCase implements ScheduleInputPort {
    private final ScheduleMapper scheduleMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final OfferedServiceRepository offeredServiceRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleManagerUseCase(ScheduleMapper scheduleMapper, CustomerRepository customerRepository, EmployeeRepository employeeRepository, OfferedServiceRepository offeredServiceRepository, ScheduleRepository scheduleRepository) {
        this.scheduleMapper = scheduleMapper;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.offeredServiceRepository = offeredServiceRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public CreatedSchedule create(CreateSchedule command) {
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
    public CreatedAppointment create(CreateAppointment command) {
        var customer = customerRepository.findById(command.getCustomerId());
        var schedule = scheduleRepository.findById(command.getScheduleId());
        var assignedSchedule = customer.assignAppointment(schedule);
        var savedAssignedSchedule = scheduleRepository.save(assignedSchedule);
        return scheduleMapper.scheduleToCreateAppointmentCommandResponse(savedAssignedSchedule);
    }

    @Override
    public List<FoundSchedule> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(scheduleMapper::scheduleToFindScheduleQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoundAppointment> find(FindCustomerAppointments query) {
        return scheduleRepository.findByCustomerId(query.getCustomerId())
                .stream()
                .map(scheduleMapper::scheduleToFindAppointmentQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoundAvailableSchedules> find(FindAvailableSchedules query) {
        return scheduleRepository
                .findAllByAvailableStatusAndCompanyIdAndDate(query.getCompanyId(), query.getRangeStartDate(), query.getRangeEndDate())
                .stream()
                .map(scheduleMapper::scheduleToFindAvailableSchedulesQueryResponse)
                .collect(Collectors.toList());
    }
}