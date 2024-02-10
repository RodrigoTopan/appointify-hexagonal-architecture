package ports.input.company.contract.query;

import ports.input.company.contract.Company;

import java.util.UUID;

public record FoundCompany(
        UUID id,
        UUID userId,
        Company company
) {
}

