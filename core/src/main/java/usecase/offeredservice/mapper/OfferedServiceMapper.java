package usecase.offeredservice.mapper;

import domain.entity.Company;
import domain.entity.OfferedService;
import domain.valueobject.Money;
import usecase.offeredservice.contract.command.CreateOfferedService;
import usecase.offeredservice.contract.command.CreatedOfferedService;
import usecase.offeredservice.contract.query.FoundOfferedService;

public class OfferedServiceMapper {
  public OfferedService createOfferedServiceCommandToOfferedService(
      Company company, CreateOfferedService command) {
    return new OfferedService(
        company, command.name(), command.description(), new Money(command.price()));
  }

  public CreatedOfferedService offeredServiceToCreateOfferedServiceCommandResponse(
      OfferedService offeredService) {
    return new CreatedOfferedService(
        offeredService.getId(),
        offeredService.getCompany().getId(),
        offeredService.getName(),
        offeredService.getDescription(),
        offeredService.getPrice().getAmount());
  }

  public FoundOfferedService offeredServiceToFindOfferedServiceQueryResponse(
      OfferedService offeredService) {
    return new FoundOfferedService(
        offeredService.getId(),
        offeredService.getCompany().getId(),
        offeredService.getName(),
        offeredService.getDescription(),
        offeredService.getPrice().getAmount());
  }
}
