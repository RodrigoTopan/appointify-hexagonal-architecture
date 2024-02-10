package ports.input.category.contract.query;

import java.util.List;
import java.util.UUID;
import ports.input.category.contract.Company;

public record FoundCategory(UUID id, String name, String image, List<Company> companies) {}
