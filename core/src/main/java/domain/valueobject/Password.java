package domain.valueobject;

import domain.common.exception.DomainValidationException;

public class Password {
  private final String value;

  public Password(String value) {
    validate(value);
    this.value = value;
  }

  void validate(String value) {
    if (value == null || value.isEmpty()) {
      throw new DomainValidationException("invalid password");
    }
  }

  public String getValue() {
    return value;
  }
}
