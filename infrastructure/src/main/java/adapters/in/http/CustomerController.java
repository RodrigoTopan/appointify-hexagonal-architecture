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
import ports.input.CustomerInputPort;
import usecase.customer.contract.command.CreateCustomer;
import usecase.customer.contract.command.CreatedCustomer;
import usecase.customer.contract.query.FoundCustomer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerInputPort customerInputPort;
    @GetMapping
    public ResponseEntity<List<FoundCustomer>> findAll() {
        return ResponseEntity.ok()
                .body(customerInputPort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoundCustomer> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(customerInputPort.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<CreatedCustomer> create(@RequestBody @Valid CreateCustomer command) {
        return ResponseEntity.ok()
                .body(customerInputPort.create(command));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        customerInputPort.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
