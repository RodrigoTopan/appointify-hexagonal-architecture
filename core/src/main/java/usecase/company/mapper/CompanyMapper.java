package usecase.company.mapper;

import usecase.company.contract.Category;
import usecase.company.contract.Company;
import usecase.company.contract.command.CreatedCompany;
import usecase.company.contract.query.FoundCompany;

import java.util.stream.Collectors;

public class CompanyMapper {

    public CreatedCompany companyToCreateCompanyCommandResponse(domain.entity.Company company) {
        var categories = company.getCategories()
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
                        company.getCompanyDetails().getImage()
                ),
                categories
        );
    }

    public FoundCompany companyToFindCompanyQueryResponse(domain.entity.Company company) {
        return new FoundCompany(
                company.getId(),
                company.getUser().getId(),
                new Company(
                        company.getCompanyDetails().getName(),
                        company.getCompanyDetails().getDescription(),
                        company.getCompanyDetails().getGovernmentId(),
                        company.getCompanyDetails().getImage()
                )
        );
    }

}
