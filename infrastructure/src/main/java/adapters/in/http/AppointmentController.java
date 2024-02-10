package adapters.in.http;

import usecase.schedules.contract.command.CreateAppointment;
import usecase.schedules.contract.command.CreateAppointmentResult;
import usecase.schedules.contract.query.FindAppointmentQueryResult;
import usecase.schedules.contract.query.FindCustomerAppointments;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.ScheduleInputPort;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final ScheduleInputPort scheduleInputPort;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<FindAppointmentQueryResult>> findByCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok()
                .body(scheduleInputPort.find(FindCustomerAppointments
                        .builder()
                        .customerId(customerId)
                        .build()));
    }

    @PostMapping
    public ResponseEntity<CreateAppointmentResult> create(
            @RequestBody @Valid CreateAppointment command) {
        return ResponseEntity.ok()
                .body(scheduleInputPort.create(command));
    }
}
