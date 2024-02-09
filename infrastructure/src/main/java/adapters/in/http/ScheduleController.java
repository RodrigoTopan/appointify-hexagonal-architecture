package adapters.in.http;

import usecase.schedules.contract.command.CreateScheduleCommand;
import usecase.schedules.contract.command.CreateScheduleCommandResponse;
import usecase.schedules.contract.query.FindAvailableSchedulesQuery;
import usecase.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import usecase.schedules.contract.query.FindScheduleQueryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ports.input.ScheduleInputPort;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleInputPort scheduleInputPort;

    @GetMapping
    public ResponseEntity<List<FindScheduleQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(scheduleInputPort.findAll());
    }

    @GetMapping("/available")
    public ResponseEntity<List<FindAvailableSchedulesQueryResponse>> findAvailability(
            @RequestParam UUID companyId,
            @RequestParam UUID offeredServiceId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date rangeStartDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date rangeEndDate
    ) {
        return ResponseEntity.ok()
                .body(scheduleInputPort.find(FindAvailableSchedulesQuery
                        .builder()
                        .companyId(companyId)
                        .offeredServiceId(offeredServiceId)
                        .rangeStartDate(rangeStartDate)
                        .rangeEndDate(rangeEndDate)
                        .build()));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateScheduleCommandResponse> create(
            @RequestBody @Valid CreateScheduleCommand command) {
        return ResponseEntity.ok()
                .body(scheduleInputPort.create(command));
    }

}
