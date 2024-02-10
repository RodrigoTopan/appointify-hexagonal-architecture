package usecase.user.contract;

public enum UserRole {
  COMPANY("COMPANY"),
  EMPLOYEE("EMPLOYEE"),
  CUSTOMER("CUSTOMER");

  private String value;

  UserRole(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
