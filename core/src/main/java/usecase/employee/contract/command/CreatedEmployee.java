package usecase.employee.contract.command;

import java.util.UUID;

public record CreatedEmployee(UUID id, UUID userId, UUID companyId) {}

