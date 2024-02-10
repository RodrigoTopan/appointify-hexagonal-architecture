package adapters.in.http;

import usecase.employee.contract.command.CreateEmployee;
import usecase.employee.contract.command.CreatedEmployee;
import usecase.employee.contract.query.FoundEmployee;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.EmployeeInputPort;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeInputPort employeeInputPort;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreatedEmployee> create(
            @RequestBody @Valid CreateEmployee command) {
        return ResponseEntity.ok()
                .body(employeeInputPort.create(command));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_COMPANY')")
    public ResponseEntity<List<FoundEmployee>> findAll() {
        return ResponseEntity.ok()
                .body(employeeInputPort.findAll());
    }
}
