package domain.entity;

import domain.common.exception.DomainException;
import domain.entity.valueobject.ScheduleDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Employee {

    private UUID id;
    private final User user;
    private final Company company;

    private final List<Schedule> schedules = new ArrayList<>();

    public Employee(User user, Company company) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.company = company;
    }

    public Employee(UUID id, User user, Company company, List<Schedule> schedules) {
        this.id = id;
        this.user = user;
        this.company = company;
        this.schedules.addAll(schedules);
    }

    public Schedule addSchedule(Date scheduleDateStart,
                                Date scheduleDateEnd,
                                OfferedService offeredService){
        var schedule = new Schedule(
                new ScheduleDate(scheduleDateStart, scheduleDateEnd),
                offeredService,
                this);

        validateIfThereIsConflicts(schedule);
        schedules.add(schedule);
        return schedule;
    }

    private void validateIfThereIsConflicts(Schedule schedule) {
        schedules.forEach(assignedSchedule -> {
            var start = assignedSchedule.getScheduleDate().getStart();
            var end = assignedSchedule.getScheduleDate().getEnd();
            if (schedule.getScheduleDate().getStart().equals(start) && schedule.getScheduleDate().getEnd().equals(end))
                throw new DomainException("Employee already has an appointment at this date time");
        });
    }

    public Schedule removeSchedule(Schedule schedule){
        schedules.remove(schedule);
        return schedule;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Company getCompany() {
        return company;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
