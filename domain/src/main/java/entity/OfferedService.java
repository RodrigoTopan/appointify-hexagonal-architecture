package entity;

import valueobject.Money;
import java.util.UUID;

public class OfferedService {
  private final UUID id;
  private final Company company;
  private final String name;
  private final String description;
  private final Money price;

  public OfferedService(Company company, String name, String description, Money price) {
    this.id = UUID.randomUUID();
    this.company = company;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public OfferedService(UUID id, Company company, String name, String description, Money price) {
    this.id = id;
    this.company = company;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public UUID getId() {
    return id;
  }

  public Company getCompany() {
    return company;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Money getPrice() {
    return price;
  }
}
