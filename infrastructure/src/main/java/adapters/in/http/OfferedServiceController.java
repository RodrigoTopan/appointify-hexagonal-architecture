package adapters.in.http;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.OfferedServiceInputPort;
import ports.input.offeredservice.contract.command.CreateOfferedService;
import ports.input.offeredservice.contract.command.CreatedOfferedService;
import ports.input.offeredservice.contract.query.FoundOfferedService;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class OfferedServiceController {

  private final OfferedServiceInputPort offeredServiceInputPort;

  @PostMapping
  @PreAuthorize("hasRole('ROLE_COMPANY')")
  public ResponseEntity<CreatedOfferedService> createOfferedService(
      @RequestBody @Valid CreateOfferedService command) {
    CreatedOfferedService response = offeredServiceInputPort.create(command);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping
  public ResponseEntity<List<FoundOfferedService>> getAllOfferedServices() {
    List<FoundOfferedService> response = offeredServiceInputPort.findAll();
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/{serviceId}")
  public ResponseEntity<FoundOfferedService> getOfferedServiceById(@PathVariable UUID serviceId) {
    return ResponseEntity.ok().body(offeredServiceInputPort.findById(serviceId));
  }
}
