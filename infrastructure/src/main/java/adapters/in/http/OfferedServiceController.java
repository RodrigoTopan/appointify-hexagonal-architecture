package adapters.in.http;

import usecase.offeredservice.contract.command.CreateOfferedService;
import usecase.offeredservice.contract.command.CreateOfferedServiceResult;
import usecase.offeredservice.contract.query.FindOfferedServiceQueryResult;
import jakarta.validation.Valid;
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

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class OfferedServiceController {

    private final OfferedServiceInputPort offeredServiceInputPort;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateOfferedServiceResult> createOfferedService(
            @RequestBody @Valid CreateOfferedService command) {
        CreateOfferedServiceResult response = offeredServiceInputPort.create(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FindOfferedServiceQueryResult>> getAllOfferedServices() {
        List<FindOfferedServiceQueryResult> response = offeredServiceInputPort.findAll();
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/{serviceId}")
    public ResponseEntity<FindOfferedServiceQueryResult> getOfferedServiceById(
            @PathVariable UUID serviceId) {
        return ResponseEntity.ok().body( offeredServiceInputPort.findById(serviceId));
    }
}
