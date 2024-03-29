package usecase.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import ports.input.company.contract.Category;
import ports.input.company.contract.Company;
import ports.input.company.contract.command.CreatedCompany;
import ports.input.company.contract.query.FoundCompany;

public class CompanyMapper {

  public CreatedCompany companyToCreateCompanyCommandResponse(entity.Company company) {
    if (company == null) {
      return null;
    }

    List<Category> categories =
        company.getCategories().stream()
            .map(category -> new Category(category.getId(), category.getName()))
            .collect(Collectors.toList());

    return new CreatedCompany(
        company.getId(),
        extractUserId(company),
        new Company(
            extractCompanyName(company),
            extractCompanyDescription(company),
            extractGovernmentId(company),
            extractImage(company)),
        categories);
  }

  public FoundCompany companyToFindCompanyQueryResponse(entity.Company company) {
    if (company == null) {
      return null;
    }

    return new FoundCompany(
        company.getId(),
        extractUserId(company),
        new Company(
            extractCompanyName(company),
            extractCompanyDescription(company),
            extractGovernmentId(company),
            extractImage(company)));
  }

  private UUID extractUserId(entity.Company company) {
    return company != null && company.getUser() != null ? company.getUser().getId() : null;
  }

  private String extractCompanyName(entity.Company company) {
    return company != null && company.getCompanyDetails() != null
        ? company.getCompanyDetails().getName()
        : null;
  }

  private String extractCompanyDescription(entity.Company company) {
    return company != null && company.getCompanyDetails() != null
        ? company.getCompanyDetails().getDescription()
        : null;
  }

  private String extractGovernmentId(entity.Company company) {
    return company != null && company.getCompanyDetails() != null
        ? company.getCompanyDetails().getGovernmentId()
        : null;
  }

  private String extractImage(entity.Company company) {
    return company != null && company.getCompanyDetails() != null
        ? company.getCompanyDetails().getImage()
        : null;
  }
}
