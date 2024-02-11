package adapters.in.http;

import adapters.in.http.json.schedules.CreateScheduleRequest;
import adapters.in.http.mapper.SchedulesJsonMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
import ports.input.schedules.contract.command.CreatedSchedule;
import ports.input.schedules.contract.query.FindAvailableSchedules;
import ports.input.schedules.contract.query.FoundAvailableSchedules;
import ports.input.schedules.contract.query.FoundSchedule;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

  private final SchedulesJsonMapper mapper;
  private final ScheduleInputPort scheduleInputPort;

  @GetMapping
  public ResponseEntity<List<FoundSchedule>> findAll() {
    return ResponseEntity.ok().body(scheduleInputPort.findAll());
  }

  @GetMapping("/available")
  public ResponseEntity<List<FoundAvailableSchedules>> findAvailability(
      @RequestParam @NotNull UUID companyId,
      @RequestParam @NotNull UUID offeredServiceId,
      @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date rangeStartDate,
      @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date rangeEndDate) {

    FindAvailableSchedules findAvailableSchedules =
        new FindAvailableSchedules(companyId, offeredServiceId, rangeStartDate, rangeEndDate);

    List<FoundAvailableSchedules> schedules = scheduleInputPort.find(findAvailableSchedules);
    return ResponseEntity.ok().body(schedules);
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_COMPANY')")
  public ResponseEntity<CreatedSchedule> create(@RequestBody @Valid CreateScheduleRequest request) {
    return ResponseEntity.ok().body(scheduleInputPort.create(mapper.toCommand(request)));
  }
}
