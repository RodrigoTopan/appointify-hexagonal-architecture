package puc.appointify.application.rest.handlers.schedules.mapper;

import entity.Schedule;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.schedules.contract.CompanyDTO;
import puc.appointify.application.rest.handlers.schedules.contract.CustomerDTO;
import puc.appointify.application.rest.handlers.schedules.contract.EmployeeDTO;
import puc.appointify.application.rest.handlers.schedules.contract.ScheduleDTO;
import puc.appointify.application.rest.handlers.schedules.contract.ServiceDTO;
import puc.appointify.application.rest.handlers.schedules.contract.command.CreateAppointmentCommandResponse;
import puc.appointify.application.rest.handlers.schedules.contract.command.CreateScheduleCommandResponse;
import puc.appointify.application.rest.handlers.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.application.rest.handlers.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import puc.appointify.application.rest.handlers.schedules.contract.query.FindScheduleQueryResponse;

@Component
public class ScheduleMapper {

    public CreateScheduleCommandResponse scheduleToCreateScheduleCommandResponse(Schedule schedule) {
        return CreateScheduleCommandResponse
                .builder()
                .id(schedule.getId())
                .scheduleStart(schedule.getScheduleDate().getStart())
                .scheduleEnd(schedule.getScheduleDate().getEnd())
                .employeeId(schedule.getEmployee().getId())
                .offeredServiceId(schedule.getOfferedService().getId())
                .isAvailable(schedule.isAvailable())
                .customerAssigneeId(
                        schedule.getCustomerAssignee() == null ?
                                null : schedule.getCustomerAssignee().getId())
                .build();
    }

    public CreateAppointmentCommandResponse scheduleToCreateAppointmentCommandResponse(Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return CreateAppointmentCommandResponse
                .builder()
                .schedule(ScheduleDTO
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(CompanyDTO
                        .builder()
                        .id(company.getId())
                        .name(company.getCompanyDetails().getName())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .customer(CustomerDTO
                        .builder()
                        .id(customer.getId())
                        .email(customer.getUser().getEmail().getValue())
                        .name(customer.getUser().getFullName())
                        .build())
                .employee(EmployeeDTO
                        .builder()
                        .id(employee.getId())
                        .name(employee.getUser().getFullName())
                        .build())
                .service(ServiceDTO
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }


    public FindScheduleQueryResponse scheduleToFindScheduleQueryResponse(Schedule schedule) {
        return FindScheduleQueryResponse
                .builder()
                .id(schedule.getId())
                .scheduleStart(schedule.getScheduleDate().getStart())
                .scheduleEnd(schedule.getScheduleDate().getEnd())
                .employeeId(schedule.getEmployee().getId())
                .offeredServiceId(schedule.getOfferedService().getId())
                .isAvailable(schedule.isAvailable())
                .customerAssigneeId(
                        schedule.getCustomerAssignee() == null
                                ? null : schedule.getCustomerAssignee().getId())
                .build();
    }

    public FindAppointmentQueryResponse scheduleToFindAppointmentQueryResponse(Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return FindAppointmentQueryResponse
                .builder()
                .schedule(ScheduleDTO
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(CompanyDTO
                        .builder()
                        .id(company.getId())
                        .name(company.getCompanyDetails().getName())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .customer(CustomerDTO
                        .builder()
                        .id(customer.getId())
                        .email(customer.getUser().getEmail().getValue())
                        .name(customer.getUser().getFullName())
                        .build())
                .employee(EmployeeDTO
                        .builder()
                        .id(employee.getId())
                        .name(employee.getUser().getFullName())
                        .build())
                .service(ServiceDTO
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }


    public FindAvailableSchedulesQueryResponse scheduleToFindAvailableSchedulesQueryResponse(Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return FindAvailableSchedulesQueryResponse
                .builder()
                .schedule(ScheduleDTO
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(CompanyDTO
                        .builder()
                        .id(company.getId())
                        .name(company.getCompanyDetails().getName())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .employee(EmployeeDTO
                        .builder()
                        .id(employee.getId())
                        .name(employee.getUser().getFullName())
                        .build())
                .service(ServiceDTO
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }
}