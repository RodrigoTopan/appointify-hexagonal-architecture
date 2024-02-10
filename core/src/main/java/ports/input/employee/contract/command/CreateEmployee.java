package ports.input.employee.contract.command;

import java.util.UUID;

public record CreateEmployee(
        UUID userId,
        UUID companyId
) {
}


