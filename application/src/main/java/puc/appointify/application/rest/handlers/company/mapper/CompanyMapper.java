package puc.appointify.application.rest.handlers.company.mapper;

import org.springframework.stereotype.Component;
import entity.Company;
import puc.appointify.application.rest.handlers.company.contract.CompanyDTO;
import puc.appointify.application.rest.handlers.company.contract.CategoryDTO;
import puc.appointify.application.rest.handlers.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.application.rest.handlers.company.contract.query.FindCompanyQueryResponse;

import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public CreateCompanyCommandResponse companyToCreateCompanyCommandResponse(Company company) {
        var categories = company.getCategories()
                .stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .collect(Collectors.toList());

        return CreateCompanyCommandResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(CompanyDTO.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .image(company.getCompanyDetails().getImage())
                        .build())
                .categories(categories)
                .build();
    }

    public FindCompanyQueryResponse companyToFindCompanyQueryResponse(Company company) {
        return FindCompanyQueryResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(CompanyDTO.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .image(company.getCompanyDetails().getImage())
                        .build())
                .build();
    }
}
