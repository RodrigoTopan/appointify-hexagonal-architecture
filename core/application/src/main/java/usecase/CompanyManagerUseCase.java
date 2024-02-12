package usecase;

import entity.Category;
import exception.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import ports.input.CompanyInputPort;
import ports.input.company.contract.command.CreateCompany;
import ports.input.company.contract.command.CreatedCompany;
import ports.input.company.contract.query.FoundCompany;
import ports.output.repository.CategoryRepository;
import ports.output.repository.CompanyRepository;
import ports.output.repository.UserRepository;
import usecase.mappers.CompanyMapper;
import valueobject.CompanyDetails;

public class CompanyManagerUseCase implements CompanyInputPort {
  private final CompanyMapper companyMapper;
  private final CompanyRepository companyRepository;
  private final CategoryRepository categoryRepository;

  private final UserRepository userRepository;

  public CompanyManagerUseCase(
      CompanyMapper companyMapper,
      CompanyRepository companyRepository,
      CategoryRepository categoryRepository,
      UserRepository userRepository) {
    this.companyMapper = companyMapper;
    this.companyRepository = companyRepository;
    this.categoryRepository = categoryRepository;
    this.userRepository = userRepository;
  }

  @Override
  public CreatedCompany create(CreateCompany command) {
    var user = userRepository.findById(command.userId());
    if (user == null) {
      throw new NotFoundException("User not found");
    }

    List<Category> savedCategories = getSavedCategories(command.categories());

    var companyDetails =
        new CompanyDetails(
            command.company().name(),
            command.company().description(),
            command.company().governmentId(),
            command.company().image());

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
  public List<FoundCompany> findAll() {
    var customers = companyRepository.findAll();
    return customers.stream()
        .map(companyMapper::companyToFindCompanyQueryResponse)
        .collect(Collectors.toList());
  }

  @Override
  public FoundCompany findById(UUID id) {
    var customer = companyRepository.findById(id);
    if (customer == null) {
      throw new NotFoundException("Customer not found");
    }
    return companyMapper.companyToFindCompanyQueryResponse(customer);
  }
}
