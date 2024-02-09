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
import adapters.in.http.handlers.company.CompanyCommandHandler;
import adapters.in.http.handlers.company.CompanyQueryHandler;
import adapters.in.http.handlers.company.contract.command.CreateCompanyCommand;
import adapters.in.http.handlers.company.contract.command.CreateCompanyCommandResponse;
import adapters.in.http.handlers.company.contract.query.FindCompanyQueryResponse;
import adapters.in.http.handlers.offeredservice.OfferedServiceQueryHandler;
import adapters.in.http.handlers.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import adapters.in.http.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyCommandHandler companyCommandHandler;
    private final CompanyQueryHandler companyQueryHandler;
    private final OfferedServiceQueryHandler offeredServiceQueryHandler;

    @GetMapping
    public ResponseEntity<List<FindCompanyQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(companyQueryHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindCompanyQueryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(companyQueryHandler.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateCompanyCommandResponse> create(
            @RequestBody @Valid CreateCompanyCommand command) {
        return ResponseEntity.ok()
                .body(companyCommandHandler.create(command));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        companyCommandHandler.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{companyId}/services")
    public ResponseEntity<List<FindOfferedServiceQueryResponse>> getOfferedServicesByCompanyId(
            @PathVariable UUID companyId) {
        FindCompanyOfferedServicesQuery query = FindCompanyOfferedServicesQuery.builder()
                .companyId(companyId)
                .build();
        List<FindOfferedServiceQueryResponse> response = offeredServiceQueryHandler.find(query);
        return ResponseEntity.ok().body(response);
    }
}
