package usecase.offeredservice.mapper;

import usecase.offeredservice.contract.command.CreateOfferedService;
import usecase.offeredservice.contract.command.CreateOfferedServiceResult;
import usecase.offeredservice.contract.query.FindOfferedServiceQueryResult;
import domain.entity.Company;
import org.springframework.stereotype.Component;
import domain.entity.OfferedService;
import domain.entity.valueobject.Money;

@Component
public class OfferedServiceMapper {
    public OfferedService createOfferedServiceCommandToOfferedService(Company company, CreateOfferedService command) {
        return new OfferedService(company, command.getName(), command.getDescription(), new Money(command.getPrice()));
    }

    public CreateOfferedServiceResult offeredServiceToCreateOfferedServiceCommandResponse(
            OfferedService offeredService) {
        return CreateOfferedServiceResult
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }

    public FindOfferedServiceQueryResult offeredServiceToFindOfferedServiceQueryResponse(
            OfferedService offeredService) {
        return FindOfferedServiceQueryResult
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }
}