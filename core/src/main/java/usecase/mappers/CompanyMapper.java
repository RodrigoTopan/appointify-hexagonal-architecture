package usecase.mappers;

import java.util.stream.Collectors;
import ports.input.company.contract.Category;
import ports.input.company.contract.Company;
import ports.input.company.contract.command.CreatedCompany;
import ports.input.company.contract.query.FoundCompany;

public class CompanyMapper {

  public CreatedCompany companyToCreateCompanyCommandResponse(domain.entity.Company company) {
    var categories =
        company
            .getCategories()
            .stream()
            .map(category -> new Category(category.getId(), category.getName()))
            .collect(Collectors.toList());

    return new CreatedCompany(
        company.getId(),
        company.getUser().getId(),
        new Company(
            company.getCompanyDetails().getName(),
            company.getCompanyDetails().getDescription(),
            company.getCompanyDetails().getGovernmentId(),
            company.getCompanyDetails().getImage()),
        categories);
  }

  public FoundCompany companyToFindCompanyQueryResponse(domain.entity.Company company) {
    return new FoundCompany(
        company.getId(),
        company.getUser().getId(),
        new Company(
            company.getCompanyDetails().getName(),
            company.getCompanyDetails().getDescription(),
            company.getCompanyDetails().getGovernmentId(),
            company.getCompanyDetails().getImage()));
  }
}
