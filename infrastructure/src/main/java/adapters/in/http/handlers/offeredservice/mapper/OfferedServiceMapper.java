package adapters.in.http.handlers.offeredservice.mapper;

import adapters.in.http.handlers.offeredservice.contract.command.CreateOfferedServiceCommand;
import adapters.in.http.handlers.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import adapters.in.http.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import entity.Company;
import org.springframework.stereotype.Component;
import entity.OfferedService;
import entity.valueobject.Money;

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