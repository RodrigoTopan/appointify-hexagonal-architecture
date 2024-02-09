package puc.appointify.application.rest.handlers.offeredservice.mapper;

import entity.Company;
import entity.Schedule;
import org.springframework.stereotype.Component;
import entity.OfferedService;
import entity.valueobject.Money;
import puc.appointify.application.rest.handlers.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.application.rest.handlers.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import puc.appointify.application.rest.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;
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
public class OfferedServiceMapper {
    public OfferedService createOfferedServiceCommandToOfferedService(Company company, CreateOfferedServiceCommand command) {
        return new OfferedService(company, command.getName(), command.getDescription(), new Money(command.getPrice()));
    }

    public CreateOfferedServiceCommandResponse offeredServiceToCreateOfferedServiceCommandResponse(
            OfferedService offeredService) {
        return CreateOfferedServiceCommandResponse
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }

    public FindOfferedServiceQueryResponse offeredServiceToFindOfferedServiceQueryResponse(
            OfferedService offeredService) {
        return FindOfferedServiceQueryResponse
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }
}