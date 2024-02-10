package usecase.category.mapper;

import domain.entity.Category;
import org.springframework.stereotype.Component;
import usecase.category.contract.CompanyDTO;
import usecase.category.contract.command.CreateCategoryCommand;
import usecase.category.contract.command.CreateCategoryCommandResponse;
import usecase.category.contract.query.FindCategoryQueryResponse;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Category createCategoryCommandToCategory(CreateCategoryCommand command) {
        return new Category(command.getName(), command.getImage());
    }

    public CreateCategoryCommandResponse categoryToCreateCategoryCommandResponse(Category category) {
        return CreateCategoryCommandResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }

    public FindCategoryQueryResponse categoryToFindCategoryQueryResponse(Category category) {
        return FindCategoryQueryResponse
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
