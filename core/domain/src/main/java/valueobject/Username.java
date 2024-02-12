package valueobject;

import exception.DomainValidationException;

public class Username {
  private final String value;

  public Username(String value) {
    validate(value);
    this.value = value;
  }

  void validate(String value) {
    if (value == null || value.isEmpty()) {
      throw new DomainValidationException("invalid username");
    }
  }

  public String getValue() {
    return value;
  }
}
