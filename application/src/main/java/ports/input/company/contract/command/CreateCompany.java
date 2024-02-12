package ports.input.company.contract.command;

import java.util.List;
import java.util.UUID;
import ports.input.company.contract.Company;

public record CreateCompany(UUID userId, Company company, List<UUID> categories) {}
