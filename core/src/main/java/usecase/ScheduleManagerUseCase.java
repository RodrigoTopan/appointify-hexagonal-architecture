package usecase;

import java.util.List;
import java.util.stream.Collectors;
import ports.input.ScheduleInputPort;
import ports.input.schedules.contract.command.CreateAppointment;
import ports.input.schedules.contract.command.CreateSchedule;
import ports.input.schedules.contract.command.CreatedAppointment;
import ports.input.schedules.contract.command.CreatedSchedule;
import ports.input.schedules.contract.query.FindAvailableSchedules;
import ports.input.schedules.contract.query.FindCustomerAppointments;
import ports.input.schedules.contract.query.FoundAppointment;
import ports.input.schedules.contract.query.FoundAvailableSchedules;
import ports.input.schedules.contract.query.FoundSchedule;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.OfferedServiceRepository;
import ports.output.repository.ScheduleRepository;
import usecase.mappers.ScheduleMapper;

public class ScheduleManagerUseCase implements ScheduleInputPort {
  private final ScheduleMapper scheduleMapper;
  private final CustomerRepository customerRepository;
  private final EmployeeRepository employeeRepository;
  private final OfferedServiceRepository offeredServiceRepository;
  private final ScheduleRepository scheduleRepository;

  public ScheduleManagerUseCase(
      ScheduleMapper scheduleMapper,
      CustomerRepository customerRepository,
      EmployeeRepository employeeRepository,
      OfferedServiceRepository offeredServiceRepository,
      ScheduleRepository scheduleRepository) {
    this.scheduleMapper = scheduleMapper;
    this.customerRepository = customerRepository;
    this.employeeRepository = employeeRepository;
    this.offeredServiceRepository = offeredServiceRepository;
    this.scheduleRepository = scheduleRepository;
  }

  @Override
  public CreatedSchedule create(CreateSchedule command) {
    var employee = employeeRepository.findById(command.employeeId());

    var offeredService = offeredServiceRepository.findById(command.offeredServiceId());

    var schedule =
        employee.addSchedule(command.scheduleStart(), command.scheduleEnd(), offeredService);

    var savedSchedule = scheduleRepository.save(schedule);
    return scheduleMapper.scheduleToCreateScheduleCommandResponse(savedSchedule);
  }

  @Override
  public CreatedAppointment create(CreateAppointment command) {
    var customer = customerRepository.findById(command.customerId());
    var schedule = scheduleRepository.findById(command.scheduleId());
    var assignedSchedule = customer.assignAppointment(schedule);
    var savedAssignedSchedule = scheduleRepository.save(assignedSchedule);
    return scheduleMapper.scheduleToCreateAppointmentCommandResponse(savedAssignedSchedule);
  }

  @Override
  public List<FoundSchedule> findAll() {
    return scheduleRepository
        .findAll()
        .stream()
        .map(scheduleMapper::scheduleToFindScheduleQueryResponse)
        .collect(Collectors.toList());
  }

  @Override
  public List<FoundAppointment> find(FindCustomerAppointments query) {
    return scheduleRepository
        .findByCustomerId(query.customerId())
        .stream()
        .map(scheduleMapper::scheduleToFindAppointmentQueryResponse)
        .collect(Collectors.toList());
  }

  @Override
  public List<FoundAvailableSchedules> find(FindAvailableSchedules query) {
    return scheduleRepository
        .findAllByAvailableStatusAndCompanyIdAndDate(
            query.companyId(), query.rangeStartDate(), query.rangeEndDate())
        .stream()
        .map(scheduleMapper::scheduleToFindAvailableSchedulesQueryResponse)
        .collect(Collectors.toList());
  }
}
