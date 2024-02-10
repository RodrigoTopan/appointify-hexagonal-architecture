package usecase.offeredservice.mapper;

import usecase.offeredservice.contract.command.CreateOfferedServiceCommand;
import usecase.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import usecase.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import domain.entity.Company;
import org.springframework.stereotype.Component;
import domain.entity.OfferedService;
import domain.entity.valueobject.Money;

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