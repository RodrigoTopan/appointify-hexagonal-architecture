package ports.input.company.contract.command;

import ports.input.company.contract.Company;

import java.util.List;
import java.util.UUID;

public record CreateCompany(
        UUID userId,
        Company company,
        List<UUID> categories
) {
}


