package usecase.company.mapper;

import usecase.company.contract.command.CreatedCompany;
import org.springframework.stereotype.Component;
import usecase.company.contract.Company;
import usecase.company.contract.Category;
import usecase.company.contract.query.FoundCompany;

import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public CreatedCompany companyToCreateCompanyCommandResponse(domain.entity.Company company) {
        var categories = company.getCategories()
                .stream()
                .map(category -> new Category(category.getId(), category.getName()))
                .collect(Collectors.toList());

        return CreatedCompany
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

    public FoundCompany companyToFindCompanyQueryResponse(domain.entity.Company company) {
        return FoundCompany
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
