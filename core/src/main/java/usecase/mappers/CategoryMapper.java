package usecase.mappers;

import domain.entity.Category;
import java.util.List;
import java.util.stream.Collectors;
import ports.input.category.contract.Company;
import ports.input.category.contract.command.CreateCategory;
import ports.input.category.contract.command.CreatedCategory;
import ports.input.category.contract.query.FoundCategory;

public class CategoryMapper {
  public Category createCategoryCommandToCategory(CreateCategory command) {
    if (command == null) {
      return null;
    }

    return new Category(command.name(), command.image());
  }

  public CreatedCategory categoryToCreateCategoryCommandResponse(Category category) {
    if (category == null) {
      return null;
    }

    return new CreatedCategory(category.getId(), category.getName(), category.getImage());
  }

  public FoundCategory categoryToFindCategoryQueryResponse(Category category) {
    if (category == null) {
      return null;
    }

    List<Company> companies =
        category.getCompanies().stream()
            .map(
                company ->
                    new Company(
                        company.getId(),
                        extractCompanyName(company),
                        extractCompanyDescription(company),
                        extractCompanyImage(company)))
            .collect(Collectors.toList());

    return new FoundCategory(category.getId(), category.getName(), category.getImage(), companies);
  }

  private String extractCompanyName(domain.entity.Company company) {
    return company != null && company.getCompanyDetails() != null
        ? company.getCompanyDetails().getName()
        : null;
  }

  private String extractCompanyDescription(domain.entity.Company company) {
    return company != null && company.getCompanyDetails() != null
        ? company.getCompanyDetails().getDescription()
        : null;
  }

  private String extractCompanyImage(domain.entity.Company company) {
    return company != null && company.getCompanyDetails() != null
        ? company.getCompanyDetails().getImage()
        : null;
  }
}
