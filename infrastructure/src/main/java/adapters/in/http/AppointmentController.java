package adapters.in.http;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.ScheduleInputPort;
import usecase.schedules.contract.command.CreateAppointment;
import usecase.schedules.contract.command.CreatedAppointment;
import usecase.schedules.contract.query.FindCustomerAppointments;
import usecase.schedules.contract.query.FoundAppointment;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

  private final ScheduleInputPort scheduleInputPort;

  @GetMapping("/{customerId}")
  public ResponseEntity<List<FoundAppointment>> findByCustomerId(@PathVariable UUID customerId) {
    return ResponseEntity.ok()
        .body(scheduleInputPort.find(new FindCustomerAppointments(customerId)));
  }

  @PostMapping
  public ResponseEntity<CreatedAppointment> create(@RequestBody @Valid CreateAppointment command) {
    return ResponseEntity.ok().body(scheduleInputPort.create(command));
  }
}
