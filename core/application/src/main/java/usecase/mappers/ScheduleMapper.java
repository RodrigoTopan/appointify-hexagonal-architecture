package usecase.mappers;

import java.util.UUID;
import ports.input.schedules.contract.Company;
import ports.input.schedules.contract.Customer;
import ports.input.schedules.contract.Employee;
import ports.input.schedules.contract.Schedule;
import ports.input.schedules.contract.Service;
import ports.input.schedules.contract.command.CreatedAppointment;
import ports.input.schedules.contract.command.CreatedSchedule;
import ports.input.schedules.contract.query.FoundAppointment;
import ports.input.schedules.contract.query.FoundAvailableSchedules;
import ports.input.schedules.contract.query.FoundSchedule;

public class ScheduleMapper {

  public CreatedSchedule scheduleToCreateScheduleCommandResponse(entity.Schedule schedule) {
    return new CreatedSchedule(
        schedule.getId(),
        schedule.getScheduleDate().getStart(),
        schedule.getScheduleDate().getEnd(),
        schedule.getEmployee().getId(),
        schedule.getOfferedService().getId(),
        schedule.isAvailable(),
        schedule.getCustomerAssignee() == null ? null : schedule.getCustomerAssignee().getId());
  }

  public CreatedAppointment scheduleToCreateAppointmentCommandResponse(entity.Schedule schedule) {
    var company = schedule.getEmployee().getCompany();
    var customer = schedule.getCustomerAssignee();
    var employee = schedule.getEmployee();
    var service = schedule.getOfferedService();

    var scheduleResponse =
        new Schedule(
            schedule.getId(),
            schedule.getScheduleDate().getStart(),
            schedule.getScheduleDate().getEnd());

    var companyResponse =
        new Company(
            company.getId(),
            company.getCompanyDetails().getName(),
            company.getCompanyDetails().getGovernmentId());

    var customerResponse =
        new Customer(
            customer.getId(),
            customer.getUser().getEmail().getValue(),
            customer.getUser().getFullName());

    var employeeResponse = new Employee(employee.getId(), employee.getUser().getFullName());

    var serviceResponse =
        new Service(
            service.getId(),
            service.getName(),
            service.getDescription(),
            service.getPrice().getAmount());

    return new CreatedAppointment(
        customerResponse, scheduleResponse, serviceResponse, employeeResponse, companyResponse);
  }

  public FoundSchedule scheduleToFindScheduleQueryResponse(entity.Schedule schedule) {
    UUID employeeId = null;
    UUID offeredServiceId = null;
    UUID customerAssigneeId = null;

    if (schedule.getEmployee() != null) {
      employeeId = schedule.getEmployee().getId();
    }

    if (schedule.getOfferedService() != null) {
      offeredServiceId = schedule.getOfferedService().getId();
    }

    if (schedule.getCustomerAssignee() != null) {
      customerAssigneeId = schedule.getCustomerAssignee().getId();
    }

    return new FoundSchedule(
        schedule.getId(),
        schedule.getScheduleDate() != null ? schedule.getScheduleDate().getStart() : null,
        schedule.getScheduleDate() != null ? schedule.getScheduleDate().getEnd() : null,
        employeeId,
        offeredServiceId,
        schedule.isAvailable(),
        customerAssigneeId);
  }

  public FoundAppointment scheduleToFindAppointmentQueryResponse(entity.Schedule schedule) {
    var company = schedule.getEmployee().getCompany();
    var customer = schedule.getCustomerAssignee();
    var employee = schedule.getEmployee();
    var service = schedule.getOfferedService();

    var scheduleResponse =
        new Schedule(
            schedule.getId(),
            schedule.getScheduleDate().getStart(),
            schedule.getScheduleDate().getEnd());

    var companyResponse =
        new Company(
            company.getId(),
            company.getCompanyDetails().getName(),
            company.getCompanyDetails().getGovernmentId());

    var customerResponse =
        new Customer(
            customer.getId(),
            customer.getUser().getEmail().getValue(),
            customer.getUser().getFullName());

    var employeeResponse = new Employee(employee.getId(), employee.getUser().getFullName());

    var serviceResponse =
        new Service(
            service.getId(),
            service.getName(),
            service.getDescription(),
            service.getPrice().getAmount());

    return new FoundAppointment(
        customerResponse, scheduleResponse, serviceResponse, employeeResponse, companyResponse);
  }

  public FoundAvailableSchedules scheduleToFindAvailableSchedulesQueryResponse(
      entity.Schedule schedule) {
    var company = schedule.getEmployee().getCompany();
    var employee = schedule.getEmployee();
    var service = schedule.getOfferedService();

    var scheduleResponse =
        new Schedule(
            schedule.getId(),
            schedule.getScheduleDate().getStart(),
            schedule.getScheduleDate().getEnd());
    var companyResponse =
        new Company(
            company.getId(),
            company.getCompanyDetails().getName(),
            company.getCompanyDetails().getGovernmentId());
    var employeeResponse = new Employee(employee.getId(), employee.getUser().getFullName());
    var serviceResponse =
        new Service(
            service.getId(),
            service.getName(),
            service.getDescription(),
            service.getPrice().getAmount());

    return new FoundAvailableSchedules(
        scheduleResponse, serviceResponse, employeeResponse, companyResponse);
  }
}
