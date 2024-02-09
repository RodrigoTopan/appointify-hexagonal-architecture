package adapters.in.http;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import adapters.in.http.handlers.employee.EmployeeCommandHandler;
import adapters.in.http.handlers.employee.EmployeeQueryHandler;
import adapters.in.http.handlers.employee.contract.command.CreateEmployeeCommand;
import adapters.in.http.handlers.employee.contract.command.CreateEmployeeCommandResponse;
import adapters.in.http.handlers.employee.contract.query.FindEmployeeQueryResponse;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeCommandHandler employeeCommandHandler;
    private final EmployeeQueryHandler employeeQueryHandler;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateEmployeeCommandResponse> create(
            @RequestBody @Valid CreateEmployeeCommand command) {
        return ResponseEntity.ok()
                .body(employeeCommandHandler.create(command));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_COMPANY')")
    public ResponseEntity<List<FindEmployeeQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(employeeQueryHandler.findAll());
    }
}
