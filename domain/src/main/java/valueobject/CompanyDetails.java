package valueobject;

import exception.DomainValidationException;

public class CompanyDetails {
  private final String name;
  private final String description;
  private final String governmentId;
  private final String image;

  // TODO: adicionar informações de endereço
  // TODO: adicionar campo de categoria

  public CompanyDetails(String name, String description, String governmentId, String image) {
    validate(name, description, governmentId);
    this.name = name;
    this.description = description;
    this.governmentId = governmentId;
    this.image = image;
  }

  void validate(String name, String description, String governmentId) {
    if (name == null || name.isEmpty()) {
      throw new DomainValidationException("company invalid name");
    }

    if (description == null || description.isEmpty()) {
      throw new DomainValidationException("company invalid description");
    }

    if (governmentId == null || governmentId.isEmpty()) {
      throw new DomainValidationException("company invalid government id");
    }
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getGovernmentId() {
    return governmentId;
  }

  public String getImage() {
    return image;
  }
}
