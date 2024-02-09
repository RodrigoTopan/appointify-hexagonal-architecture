package adapters.in.http;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import adapters.in.http.handlers.customer.contract.command.CreateCustomerCommand;
import adapters.in.http.handlers.customer.contract.command.CreateCustomerCommandResponse;
import adapters.in.http.handlers.customer.contract.query.FindCustomerQueryResponse;
import adapters.in.http.handlers.customer.CustomerCommandHandler;
import adapters.in.http.handlers.customer.CustomerQueryHandler;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerCommandHandler customerCommandHandler;
    private final CustomerQueryHandler customerQueryHandler;

    @GetMapping
    public ResponseEntity<List<FindCustomerQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(customerQueryHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindCustomerQueryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(customerQueryHandler.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<CreateCustomerCommandResponse> create(@RequestBody @Valid CreateCustomerCommand command) {
        return ResponseEntity.ok()
                .body(customerCommandHandler.create(command));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        customerCommandHandler.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
