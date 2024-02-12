package usecase.mappers;

import entity.Company;
import entity.OfferedService;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import ports.input.offeredservice.contract.command.CreateOfferedService;
import ports.input.offeredservice.contract.command.CreatedOfferedService;
import ports.input.offeredservice.contract.query.FoundOfferedService;
import valueobject.Money;

public class OfferedServiceMapper {

  public OfferedService createOfferedServiceCommandToOfferedService(
      Company company, CreateOfferedService command) {
    return new OfferedService(
        company, command.name(), command.description(), new Money(command.price()));
  }

  public CreatedOfferedService offeredServiceToCreateOfferedServiceCommandResponse(
      OfferedService offeredService) {
    return new CreatedOfferedService(
        extractId(offeredService),
        extractCompanyId(offeredService),
        extractName(offeredService),
        extractDescription(offeredService),
        extractPriceAmount(offeredService));
  }

  public FoundOfferedService offeredServiceToFindOfferedServiceQueryResponse(
      OfferedService offeredService) {
    return new FoundOfferedService(
        extractId(offeredService),
        extractCompanyId(offeredService),
        extractName(offeredService),
        extractDescription(offeredService),
        extractPriceAmount(offeredService));
  }

  private UUID extractId(OfferedService offeredService) {
    return Optional.ofNullable(offeredService).map(OfferedService::getId).orElse(null);
  }

  private UUID extractCompanyId(OfferedService offeredService) {
    return Optional.ofNullable(offeredService)
        .map(OfferedService::getCompany)
        .map(Company::getId)
        .orElse(null);
  }

  private String extractName(OfferedService offeredService) {
    return Optional.ofNullable(offeredService).map(OfferedService::getName).orElse(null);
  }

  private String extractDescription(OfferedService offeredService) {
    return Optional.ofNullable(offeredService).map(OfferedService::getDescription).orElse(null);
  }

  private BigDecimal extractPriceAmount(OfferedService offeredService) {
    return Optional.ofNullable(offeredService)
        .map(OfferedService::getPrice)
        .map(Money::getAmount)
        .orElse(null);
  }
}
