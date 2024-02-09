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
import ports.input.CompanyInputPort;
import ports.input.OfferedServiceInputPort;
import usecase.company.contract.command.CreateCompany;
import usecase.company.contract.command.CreateCompanyResponse;
import usecase.company.contract.query.FindCompanyResponse;
import usecase.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import usecase.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyInputPort companyInputPort;
    private final OfferedServiceInputPort offeredServiceInputPort;

    @GetMapping
    public ResponseEntity<List<FindCompanyResponse>> findAll() {
        return ResponseEntity.ok()
                .body(companyInputPort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindCompanyResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(companyInputPort.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateCompanyResponse> create(
            @RequestBody @Valid CreateCompany command) {
        return ResponseEntity.ok()
                .body(companyInputPort.create(command));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        companyInputPort.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{companyId}/services")
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> getOfferedServicesByCompanyId(
            @PathVariable UUID companyId) {
        FindCompanyOfferedServicesQuery query = FindCompanyOfferedServicesQuery.builder()
                .companyId(companyId)
                .build();
        List<FindOfferedServiceQueryResponse> response = offeredServiceInputPort.find(query);
        return ResponseEntity.ok().body(response);
    }
}
