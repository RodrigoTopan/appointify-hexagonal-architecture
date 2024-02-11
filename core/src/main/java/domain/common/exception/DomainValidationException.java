package domain.common.exception;

public class DomainValidationException extends IllegalArgumentException {

  public DomainValidationException(String message) {
    super(message);
  }

  public DomainValidationException(String message, Throwable cause) {
    super(message, cause);
  }
}
