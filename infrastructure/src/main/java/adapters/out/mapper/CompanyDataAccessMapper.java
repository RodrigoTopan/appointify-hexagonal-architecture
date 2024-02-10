package adapters.out.mapper;

import adapters.out.entity.CategoryEntity;
import adapters.out.entity.CompanyEntity;
import adapters.out.entity.UserEntity;
import domain.entity.Category;
import domain.entity.Company;
import domain.entity.User;
import domain.valueobject.CompanyDetails;
import domain.valueobject.Email;
import domain.valueobject.Password;
import domain.valueobject.UserRole;
import domain.valueobject.Username;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyDataAccessMapper {

  public static CompanyEntity toEntity(Company company) {
    if (company == null) return null;

    var companyCategories = company.getCategories();

    List<CategoryEntity> categoriesEntities = new ArrayList<>();
    if (companyCategories != null) {
      categoriesEntities.addAll(
          companyCategories.stream().map(CompanyDataAccessMapper::toEntity).toList());
    }

    return CompanyEntity.builder()
        .id(company.getId())
        .user(
            UserEntity.builder()
                .id(company.getUser().getId())
                .firstName(company.getUser().getFirstName())
                .lastName(company.getUser().getLastName())
                .username(company.getUser().getUsername().getValue())
                .email(company.getUser().getEmail().getValue())
                .role(company.getUser().getRole().getValue())
                .build())
        .companyName(company.getCompanyDetails().getName())
        .companyDescription(company.getCompanyDetails().getDescription())
        .companyGovernmentId(company.getCompanyDetails().getGovernmentId())
        .companyImage(company.getCompanyDetails().getImage())
        .categories(categoriesEntities)
        .build();
  }

  public static Company toDomain(CompanyEntity entity) {
    if (entity == null) return null;

    var userEntity = entity.getUser();
    var user =
        new User(
            userEntity.getId(),
            userEntity.getFirstName(),
            userEntity.getLastName(),
            new Username(userEntity.getUsername()),
            new Email(userEntity.getEmail()),
            new Password(userEntity.getPassword()),
            UserRole.valueOf(userEntity.getRole()));

    var companyDetails =
        new CompanyDetails(
            entity.getCompanyName(),
            entity.getCompanyDescription(),
            entity.getCompanyGovernmentId(),
            entity.getCompanyImage());

    var entityCategories = entity.getCategories();
    if (entityCategories != null) {
      var categories =
          entityCategories
              .stream()
              .map(CompanyDataAccessMapper::toDomain)
              .collect(Collectors.toList());
      return new Company(entity.getId(), user, companyDetails, new ArrayList<>(), categories);
    }

    return new Company(entity.getId(), user, companyDetails, new ArrayList<>(), new ArrayList<>());
  }

  public static CategoryEntity toEntity(Category category) {
    if (category == null) return null;
    return CategoryEntity.builder().id(category.getId()).name(category.getName()).build();
  }

  public static Category toDomain(CategoryEntity entity) {
    if (entity == null) return null;
    return new Category(entity.getName(), entity.getImage());
  }
}
