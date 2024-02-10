package usecase.category.mapper;

import domain.entity.Category;
import org.springframework.stereotype.Component;
import usecase.category.contract.CompanyDTO;
import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreateCategoryResult;
import usecase.category.contract.query.FindCategoryResult;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Category createCategoryCommandToCategory(CreateCategory command) {
        return new Category(command.getName(), command.getImage());
    }

    public CreateCategoryResult categoryToCreateCategoryCommandResponse(Category category) {
        return CreateCategoryResult
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }

    public FindCategoryResult categoryToFindCategoryQueryResponse(Category category) {
        return FindCategoryResult
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
