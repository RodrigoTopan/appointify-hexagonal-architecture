package entity;

import common.exception.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    private UUID id;

    private final User user;

    private final List<Schedule> schedules = new ArrayList<>();

    private final List<Evaluation> evaluations = new ArrayList<>();

    public Customer(User user) {
        this.id = UUID.randomUUID();
        this.user = user;
    }

    public Customer(User user, List<Schedule> schedules, List<Evaluation> evaluations) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.schedules.addAll(schedules);
        this.evaluations.addAll(evaluations);
    }

    public Customer(UUID id, User user, List<Schedule> schedules, List<Evaluation> evaluations) {
        this.id = id;
        this.user = user;
        this.schedules.addAll(schedules);
        this.evaluations.addAll(evaluations);
    }

    public Schedule assignAppointment(Schedule schedule) {
        validateAssignment(schedule);
        schedule.createAppointment(this);
        schedules.add(schedule);
        return schedule;
    }

    private void validateAssignment(Schedule schedule) {
        checkIfCustomerAlreadyHasAssignedForThisSchedule(schedule);
        checkIfCustomerAlreadyHasDateConflicts(schedule);
    }

    private void checkIfCustomerAlreadyHasAssignedForThisSchedule(Schedule schedule) {
        boolean hasEqualCustomerAssignee = schedules.stream()
                .anyMatch(assignedSchedule ->
                        Objects.equals(assignedSchedule.getCustomerAssignee(), this) &&
                                Objects.equals(assignedSchedule.getId(), schedule.getId()));

        if (hasEqualCustomerAssignee) {
            throw new DomainException("Schedule is already assigned to you");
        }
    }

    private void checkIfCustomerAlreadyHasDateConflicts(Schedule schedule) {
        schedules.forEach(assignedSchedule -> {
            if (assignedSchedule.getScheduleDate().overlaps(schedule.getScheduleDate())) {
                throw new DomainException("Schedule conflicts with an appointment already assigned to you");
            }
        });
    }

    public Evaluation evaluateEmployee(Integer rate, String comment, Employee employee) {
        var evaluation = new Evaluation(rate, comment, employee, this);
        this.evaluations.add(evaluation);
        return evaluation;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
