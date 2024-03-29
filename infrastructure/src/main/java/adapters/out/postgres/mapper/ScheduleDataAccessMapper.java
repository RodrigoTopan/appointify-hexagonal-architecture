package adapters.out.postgres.mapper;

import adapters.out.postgres.entity.ScheduleEntity;
import entity.Schedule;
import valueobject.ScheduleDate;

public class ScheduleDataAccessMapper {

  public static ScheduleEntity toEntity(Schedule schedule) {
    if (schedule == null) return null;
    return ScheduleEntity.builder()
        .id(schedule.getId())
        .dateStart(schedule.getScheduleDate().getStart())
        .dateEnd(schedule.getScheduleDate().getEnd())
        .employee(EmployeeDataAccessMapper.toEntity(schedule.getEmployee()))
        .offeredService(OfferedServiceDataAccessMapper.toEntity(schedule.getOfferedService()))
        .customer(CustomerDataAccessMapper.toEntity(schedule.getCustomerAssignee()))
        .isAvailable(schedule.isAvailable())
        .build();
  }

  public static Schedule toDomain(ScheduleEntity entity) {
    if (entity == null) return null;

    return new Schedule(
        entity.getId(),
        new ScheduleDate(entity.getDateStart(), entity.getDateEnd()),
        OfferedServiceDataAccessMapper.toDomain(entity.getOfferedService()),
        EmployeeDataAccessMapper.toDomain(entity.getEmployee()),
        entity.isAvailable(),
        CustomerDataAccessMapper.toDomain(entity.getCustomer()));
  }
}
