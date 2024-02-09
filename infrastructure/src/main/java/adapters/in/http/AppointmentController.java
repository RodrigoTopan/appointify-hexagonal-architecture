package adapters.in.http;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import adapters.in.http.handlers.schedules.ScheduleQueryHandler;
import adapters.in.http.handlers.schedules.ScheduleCommandHandler;
import adapters.in.http.handlers.schedules.contract.command.CreateAppointmentCommand;
import adapters.in.http.handlers.schedules.contract.command.CreateAppointmentCommandResponse;
import adapters.in.http.handlers.schedules.contract.query.FindAppointmentQueryResponse;
import adapters.in.http.handlers.schedules.contract.query.FindCustomerAppointmentsQuery;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final ScheduleCommandHandler scheduleCommandHandler;
    private final ScheduleQueryHandler scheduleQueryHandler;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<FindAppointmentQueryResponse>> findByCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok()
                .body(scheduleQueryHandler.find(FindCustomerAppointmentsQuery
                        .builder()
                        .customerId(customerId)
                        .build()));
    }

    @PostMapping
    public ResponseEntity<CreateAppointmentCommandResponse> create(
            @RequestBody @Valid CreateAppointmentCommand command) {
        return ResponseEntity.ok()
                .body(scheduleCommandHandler.create(command));
    }
}
