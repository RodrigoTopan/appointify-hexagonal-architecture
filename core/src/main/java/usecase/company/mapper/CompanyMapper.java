package usecase.company.mapper;

import usecase.company.contract.command.CreateCompanyResponse;
import org.springframework.stereotype.Component;
import usecase.company.contract.Company;
import usecase.company.contract.Category;
import usecase.company.contract.query.FindCompanyResponse;

import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public CreateCompanyResponse companyToCreateCompanyCommandResponse(domain.entity.Company company) {
        var categories = company.getCategories()
                .stream()
                .map(category -> new Category(category.getId(), category.getName()))
                .collect(Collectors.toList());

        return CreateCompanyResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(Company.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .image(company.getCompanyDetails().getImage())
                        .build())
                .categories(categories)
                .build();
    }

    public FindCompanyResponse companyToFindCompanyQueryResponse(domain.entity.Company company) {
        return FindCompanyResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(Company.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .image(company.getCompanyDetails().getImage())
                        .build())
                .build();
    }
}
