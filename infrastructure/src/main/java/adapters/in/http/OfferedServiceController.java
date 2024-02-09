package adapters.in.http;

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
import adapters.in.http.handlers.offeredservice.OfferedServiceCommandHandler;
import adapters.in.http.handlers.offeredservice.OfferedServiceQueryHandler;
import adapters.in.http.handlers.offeredservice.contract.command.CreateOfferedServiceCommand;
import adapters.in.http.handlers.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import adapters.in.http.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class OfferedServiceController {

    private final OfferedServiceCommandHandler offeredServiceCommandHandler;
    private final OfferedServiceQueryHandler offeredServiceQueryHandler;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateOfferedServiceCommandResponse> createOfferedService(
            @RequestBody @Valid CreateOfferedServiceCommand command) {
        CreateOfferedServiceCommandResponse response = offeredServiceCommandHandler.create(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> getAllOfferedServices() {
        List<FindOfferedServiceQueryResponse> response = offeredServiceQueryHandler.findAll();
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/{serviceId}")
    public ResponseEntity<FindOfferedServiceQueryResponse> getOfferedServiceById(
            @PathVariable UUID serviceId) {
        return ResponseEntity.ok().body( offeredServiceQueryHandler.findById(serviceId));
    }
}
