package ports.input;

import java.util.List;
import ports.input.schedules.contract.command.CreateAppointment;
import ports.input.schedules.contract.command.CreateSchedule;
import ports.input.schedules.contract.command.CreatedAppointment;
import ports.input.schedules.contract.command.CreatedSchedule;
import ports.input.schedules.contract.query.FindAvailableSchedules;
import ports.input.schedules.contract.query.FindCustomerAppointments;
import ports.input.schedules.contract.query.FoundAppointment;
import ports.input.schedules.contract.query.FoundAvailableSchedules;
import ports.input.schedules.contract.query.FoundSchedule;

public interface ScheduleInputPort {
  CreatedSchedule create(CreateSchedule command);

  CreatedAppointment create(CreateAppointment command);

  List<FoundSchedule> findAll();

  List<FoundAppointment> find(FindCustomerAppointments query);

  List<FoundAvailableSchedules> find(FindAvailableSchedules query);
}
