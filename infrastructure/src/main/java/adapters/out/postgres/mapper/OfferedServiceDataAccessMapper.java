package adapters.out.postgres.mapper;

import adapters.out.postgres.entity.OfferedServiceEntity;
import entity.OfferedService;
import valueobject.Money;

public class OfferedServiceDataAccessMapper {

  public static OfferedServiceEntity toEntity(OfferedService domain) {
    if (domain == null) return null;
    var company = domain.getCompany();
    var companyEntity = CompanyDataAccessMapper.toEntity(company);

    return OfferedServiceEntity.builder()
        .id(domain.getId())
        .name(domain.getName())
        .description(domain.getDescription())
        .price(domain.getPrice().getAmount())
        .company(companyEntity)
        .build();
  }

  public static OfferedService toDomain(OfferedServiceEntity entity) {
    if (entity == null) return null;
    var company = CompanyDataAccessMapper.toDomain(entity.getCompany());
    return new OfferedService(
        entity.getId(),
        company,
        entity.getName(),
        entity.getDescription(),
        new Money(entity.getPrice()));
  }
}
