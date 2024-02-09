package adapters.in.http.handlers.company.impl;

import adapters.in.http.handlers.company.CompanyCommandHandler;
import adapters.in.http.handlers.company.contract.command.CreateCompanyCommand;
import adapters.in.http.handlers.company.contract.command.CreateCompanyCommandResponse;
import adapters.in.http.handlers.company.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import entity.Category;
import entity.valueobject.CompanyDetails;
import ports.output.repository.CategoryRepository;
import ports.output.repository.CompanyRepository;
import ports.output.repository.UserRepository;

import java.util.ArrayList;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompanyCommandHandlerImpl implements CompanyCommandHandler {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    @Override
    public CreateCompanyCommandResponse create(CreateCompanyCommand command) {
        var user = userRepository.findById(command.getUserId());

        var appliedCategories = command.getCategories();

        var savedCategories = new ArrayList<Category>();
        if(!appliedCategories.isEmpty()) {
            savedCategories.addAll(categoryRepository.findAllById(command.getCategories()));
        }

        var companyDetails = new CompanyDetails(
                command.getCompany().getName(),
                command.getCompany().getDescription(),
                command.getCompany().getGovernmentId(),
                command.getCompany().getImage());

        var company = user.createCompany(companyDetails, savedCategories);
        var savedCompany = companyRepository.save(company);
        return companyMapper.companyToCreateCompanyCommandResponse(savedCompany);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

}
