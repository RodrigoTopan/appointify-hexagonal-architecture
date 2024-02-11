package domain.valueobject;

import domain.common.exception.DomainValidationException;

public class Email {
  private String value;

  public Email(String value) {
    validate(value);
    this.value = value;
  }

  void validate(String value) {
    if (value == null || value.isEmpty()) {
      throw new DomainValidationException("invalid email");
    }
  }

  public String getValue() {
    return value;
  }
}
