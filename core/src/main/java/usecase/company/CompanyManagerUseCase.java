package usecase.company;

import usecase.company.contract.command.CreateCompany;
import usecase.company.contract.command.CreateCompanyResult;
import usecase.company.contract.query.FindCompanyResult;
import usecase.company.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import domain.entity.Category;
import domain.entity.valueobject.CompanyDetails;
import ports.input.CompanyInputPort;
import ports.output.repository.CategoryRepository;
import ports.output.repository.CompanyRepository;
import ports.output.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyManagerUseCase implements CompanyInputPort {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    @Override
    public CreateCompanyResult create(CreateCompany command) {
        var user = userRepository.findById(command.getUserId());

        List<Category> savedCategories = getSavedCategories(command.getCategories());

        var companyDetails = new CompanyDetails(
                command.getCompany().getName(),
                command.getCompany().getDescription(),
                command.getCompany().getGovernmentId(),
                command.getCompany().getImage());

        var company = user.createCompany(companyDetails, savedCategories);
        var savedCompany = companyRepository.save(company);
        return companyMapper.companyToCreateCompanyCommandResponse(savedCompany);
    }

    private List<Category> getSavedCategories(List<UUID> categoryIds) {
        List<Category> savedCategories = new ArrayList<>();
        if (!categoryIds.isEmpty()) {
            savedCategories.addAll(categoryRepository.findAllById(categoryIds));
        }
        return savedCategories;
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }


    @Override
    public List<FindCompanyResult> findAll() {
        var customers = companyRepository.findAll();
        return customers.stream()
                .map(companyMapper::companyToFindCompanyQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCompanyResult findById(UUID id) {
        var customer = companyRepository.findById(id);
        return companyMapper.companyToFindCompanyQueryResponse(customer);
    }

}
