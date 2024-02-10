package usecase.mappers;

import domain.entity.Category;
import java.util.stream.Collectors;
import ports.input.category.contract.Company;
import ports.input.category.contract.command.CreateCategory;
import ports.input.category.contract.command.CreatedCategory;
import ports.input.category.contract.query.FoundCategory;

public class CategoryMapper {
  public Category createCategoryCommandToCategory(CreateCategory command) {
    return new Category(command.name(), command.image());
  }

  public CreatedCategory categoryToCreateCategoryCommandResponse(Category category) {
    return new CreatedCategory(category.getId(), category.getName(), category.getImage());
  }

  public FoundCategory categoryToFindCategoryQueryResponse(Category category) {
    return new FoundCategory(
        category.getId(),
        category.getName(),
        category.getImage(),
        category
            .getCompanies()
            .stream()
            .map(
                company ->
                    new Company(
                        company.getId(),
                        company.getCompanyDetails().getName(),
                        company.getCompanyDetails().getDescription(),
                        company.getCompanyDetails().getImage()))
            .collect(Collectors.toList()));
  }
}
