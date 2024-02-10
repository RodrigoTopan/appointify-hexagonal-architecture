package usecase.schedules.mapper;

import usecase.schedules.contract.Company;
import usecase.schedules.contract.Customer;
import usecase.schedules.contract.Employee;
import usecase.schedules.contract.Schedule;
import usecase.schedules.contract.Service;
import usecase.schedules.contract.command.CreatedAppointment;
import usecase.schedules.contract.command.CreatedSchedule;
import usecase.schedules.contract.query.FoundAppointment;
import usecase.schedules.contract.query.FoundAvailableSchedules;
import usecase.schedules.contract.query.FoundSchedule;

public class ScheduleMapper {

  public CreatedSchedule scheduleToCreateScheduleCommandResponse(domain.entity.Schedule schedule) {
    return new CreatedSchedule(
        schedule.getId(),
        schedule.getScheduleDate().getStart(),
        schedule.getScheduleDate().getEnd(),
        schedule.getEmployee().getId(),
        schedule.getOfferedService().getId(),
        schedule.isAvailable(),
        schedule.getCustomerAssignee() == null ? null : schedule.getCustomerAssignee().getId());
  }

  public CreatedAppointment scheduleToCreateAppointmentCommandResponse(
      domain.entity.Schedule schedule) {
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

  public FoundSchedule scheduleToFindScheduleQueryResponse(domain.entity.Schedule schedule) {
    return new FoundSchedule(
        schedule.getId(),
        schedule.getScheduleDate().getStart(),
        schedule.getScheduleDate().getEnd(),
        schedule.getEmployee().getId(),
        schedule.getOfferedService().getId(),
        schedule.isAvailable(),
        schedule.getCustomerAssignee() == null ? null : schedule.getCustomerAssignee().getId());
  }

  public FoundAppointment scheduleToFindAppointmentQueryResponse(domain.entity.Schedule schedule) {
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
      domain.entity.Schedule schedule) {
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
