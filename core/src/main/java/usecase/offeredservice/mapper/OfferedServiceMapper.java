package usecase.offeredservice.mapper;

import usecase.offeredservice.contract.command.CreateOfferedService;
import usecase.offeredservice.contract.command.CreatedOfferedService;
import usecase.offeredservice.contract.query.FoundOfferedService;
import domain.entity.Company;
import org.springframework.stereotype.Component;
import domain.entity.OfferedService;
import domain.valueobject.Money;

@Component
public class OfferedServiceMapper {
    public OfferedService createOfferedServiceCommandToOfferedService(Company company, CreateOfferedService command) {
        return new OfferedService(company, command.getName(), command.getDescription(), new Money(command.getPrice()));
    }

    public CreatedOfferedService offeredServiceToCreateOfferedServiceCommandResponse(
            OfferedService offeredService) {
        return CreatedOfferedService
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }

    public FoundOfferedService offeredServiceToFindOfferedServiceQueryResponse(
            OfferedService offeredService) {
        return FoundOfferedService
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }
}