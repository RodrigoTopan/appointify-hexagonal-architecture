package ports.input.category.contract.query;

import ports.input.category.contract.Company;

import java.util.List;
import java.util.UUID;

public record FoundCategory(
        UUID id,
        String name,
        String image,
        List<Company> companies
) {
}

