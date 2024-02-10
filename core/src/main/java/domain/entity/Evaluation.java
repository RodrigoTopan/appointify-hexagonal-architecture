package domain.entity;

import java.util.UUID;

public class Evaluation {
  private UUID id;
  private final Integer rate;
  private final String comment;
  private final Employee employee;
  private final Customer customer;

  public Evaluation(Integer rate, String comment, Employee employee, Customer customer) {
    this.id = UUID.randomUUID();
    this.rate = rate;
    this.comment = comment;
    this.employee = employee;
    this.customer = customer;
  }

  public Evaluation(UUID id, Integer rate, String comment, Employee employee, Customer customer) {
    this.id = UUID.randomUUID();
    this.rate = rate;
    this.comment = comment;
    this.employee = employee;
    this.customer = customer;
  }

  public UUID getId() {
    return id;
  }

  public Integer getRate() {
    return rate;
  }

  public String getComment() {
    return comment;
  }

  public Employee getEmployee() {
    return employee;
  }

  public Customer getCustomer() {
    return customer;
  }
}
