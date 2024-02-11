package adapters.in.http.mapper;

import adapters.in.http.json.schedules.CreateScheduleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.schedules.contract.command.CreateSchedule;

@Mapper(componentModel = "spring")
public interface SchedulesJsonMapper {
  SchedulesJsonMapper INSTANCE = Mappers.getMapper(SchedulesJsonMapper.class);

  CreateSchedule toCommand(CreateScheduleRequest request);
}
