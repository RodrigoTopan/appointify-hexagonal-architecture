package usecase.category.mapper;

import domain.entity.Category;
import org.springframework.stereotype.Component;
import usecase.category.contract.CompanyDTO;
import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreatedCategory;
import usecase.category.contract.query.FoundCategory;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Category createCategoryCommandToCategory(CreateCategory command) {
        return new Category(command.getName(), command.getImage());
    }

    public CreatedCategory categoryToCreateCategoryCommandResponse(Category category) {
        return CreatedCategory
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }

    public FoundCategory categoryToFindCategoryQueryResponse(Category category) {
        return FoundCategory
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .companies(category.getCompanies()
                        .stream()
                        .map(company -> new CompanyDTO(company.getId(),
                                company.getCompanyDetails().getName(),
                                company.getCompanyDetails().getDescription(),
                                company.getCompanyDetails().getImage()))
                        .collect(Collectors.toList()))
                .build();
    }
}
