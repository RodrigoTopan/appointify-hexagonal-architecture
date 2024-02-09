package adapters.in.http;

import usecase.schedules.contract.command.CreateAppointmentCommand;
import usecase.schedules.contract.command.CreateAppointmentCommandResponse;
import usecase.schedules.contract.query.FindAppointmentQueryResponse;
import usecase.schedules.contract.query.FindCustomerAppointmentsQuery;
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
    public ResponseEntity<List<FindAppointmentQueryResponse>> findByCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok()
                .body(scheduleInputPort.find(FindCustomerAppointmentsQuery
                        .builder()
                        .customerId(customerId)
                        .build()));
    }

    @PostMapping
    public ResponseEntity<CreateAppointmentCommandResponse> create(
            @RequestBody @Valid CreateAppointmentCommand command) {
        return ResponseEntity.ok()
                .body(scheduleInputPort.create(command));
    }
}
