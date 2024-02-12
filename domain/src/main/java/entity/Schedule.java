package entity;

import exception.DomainException;
import valueobject.ScheduleDate;
import java.util.UUID;

public class Schedule {
  private final UUID id;
  private final ScheduleDate scheduleDate;
  private final OfferedService offeredService;
  private final Employee employee;
  private boolean isAvailable;
  private Customer customerAssignee;

  public Schedule(ScheduleDate scheduleDate, OfferedService offeredService, Employee employee) {
    this.id = UUID.randomUUID();
    this.scheduleDate = scheduleDate;
    this.offeredService = offeredService;
    this.employee = employee;
    this.isAvailable = true;
  }

  public Schedule(
      UUID id,
      ScheduleDate scheduleDate,
      OfferedService offeredService,
      Employee employee,
      boolean isAvailable,
      Customer customerAssignee) {
    this.id = id;
    this.scheduleDate = scheduleDate;
    this.offeredService = offeredService;
    this.employee = employee;
    this.isAvailable = isAvailable;
    this.customerAssignee = customerAssignee;
  }

  public void createAppointment(Customer customerAssignee) {
    checkIfScheduleAlreadyHasRegisteredCustomer();
    this.isAvailable = false;
    this.customerAssignee = customerAssignee;
  }

  private void checkIfScheduleAlreadyHasRegisteredCustomer() {
    if (this.getCustomerAssignee() != null || !this.isAvailable())
      throw new DomainException("schedule is already assigned to another customer");
  }

  public UUID getId() {
    return id;
  }

  public ScheduleDate getScheduleDate() {
    return scheduleDate;
  }

  public OfferedService getOfferedService() {
    return offeredService;
  }

  public Employee getEmployee() {
    return employee;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public Customer getCustomerAssignee() {
    return customerAssignee;
  }
}
