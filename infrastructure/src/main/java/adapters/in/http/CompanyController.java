package adapters.in.http;

import adapters.in.http.json.company.CreateCompanyRequest;
import adapters.in.http.mapper.CompanyJsonMapper;
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
import ports.input.CompanyInputPort;
import ports.input.OfferedServiceInputPort;
import ports.input.company.contract.command.CreatedCompany;
import ports.input.company.contract.query.FoundCompany;
import ports.input.offeredservice.contract.query.FindCompanyOfferedServices;
import ports.input.offeredservice.contract.query.FoundOfferedService;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

  private final CompanyJsonMapper companyMapper;
  private final CompanyInputPort companyInputPort;
  private final OfferedServiceInputPort offeredServiceInputPort;

  @GetMapping
  public ResponseEntity<List<FoundCompany>> findAll() {
    return ResponseEntity.ok().body(companyInputPort.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<FoundCompany> findById(@PathVariable UUID id) {
    return ResponseEntity.ok().body(companyInputPort.findById(id));
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_COMPANY')")
  public ResponseEntity<CreatedCompany> create(@RequestBody @Valid CreateCompanyRequest request) {
    return ResponseEntity.ok().body(companyInputPort.create(companyMapper.toCommand(request)));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ROLE_COMPANY')")
  public ResponseEntity<?> deleteById(@PathVariable UUID id) {
    companyInputPort.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{companyId}/services")
  public ResponseEntity<List<FoundOfferedService>> getOfferedServicesByCompanyId(
      @PathVariable UUID companyId) {
    FindCompanyOfferedServices query = new FindCompanyOfferedServices(companyId);
    List<FoundOfferedService> response = offeredServiceInputPort.find(query);
    return ResponseEntity.ok().body(response);
  }
}
