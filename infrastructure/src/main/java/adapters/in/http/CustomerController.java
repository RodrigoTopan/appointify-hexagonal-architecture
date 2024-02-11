package adapters.in.http;

import adapters.in.http.json.customer.CreateCustomerRequest;
import adapters.in.http.mapper.CustomerJsonMapper;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
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
import ports.input.customer.contract.command.CreatedCustomer;
import ports.input.customer.contract.query.FoundCustomer;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerJsonMapper mapper;
  private final CustomerInputPort customerInputPort;

  @GetMapping
  public ResponseEntity<List<FoundCustomer>> findAll() {
    return ResponseEntity.ok().body(customerInputPort.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<FoundCustomer> findById(@PathVariable UUID id) {
    return ResponseEntity.ok().body(customerInputPort.findById(id));
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_CUSTOMER')")
  public ResponseEntity<CreatedCustomer> create(@RequestBody @Valid CreateCustomerRequest request) {
    return ResponseEntity.ok().body(customerInputPort.create(mapper.toCommand(request)));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ROLE_CUSTOMER')")
  public ResponseEntity<?> deleteById(@PathVariable UUID id) {
    customerInputPort.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
