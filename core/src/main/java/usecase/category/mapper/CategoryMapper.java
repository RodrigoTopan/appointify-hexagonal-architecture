package usecase.category.mapper;

import domain.entity.Category;

import usecase.category.contract.Company;
import usecase.category.contract.command.CreateCategory;
import usecase.category.contract.command.CreatedCategory;
import usecase.category.contract.query.FoundCategory;

import java.util.stream.Collectors;


public class CategoryMapper {
    public Category createCategoryCommandToCategory(CreateCategory command) {
        return new Category(command.name(), command.image());
    }

    public CreatedCategory categoryToCreateCategoryCommandResponse(Category category) {
        return new CreatedCategory(
                category.getId(),
                category.getName(),
                category.getImage()
        );
    }


    public FoundCategory categoryToFindCategoryQueryResponse(Category category) {
        return new FoundCategory(
                category.getId(),
                category.getName(),
                category.getImage(),
                category.getCompanies().stream()
                        .map(company -> new Company(
                                company.getId(),
                                company.getCompanyDetails().getName(),
                                company.getCompanyDetails().getDescription(),
                                company.getCompanyDetails().getImage()))
                        .collect(Collectors.toList())
        );
    }
}
