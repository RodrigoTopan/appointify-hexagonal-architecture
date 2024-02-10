package ports.input.company.contract.command;

import ports.input.company.contract.Category;
import ports.input.company.contract.Company;

import java.util.List;
import java.util.UUID;

public record CreatedCompany(
        UUID id,
        UUID userId,
        Company company,
        List<Category> categories
) {
}

