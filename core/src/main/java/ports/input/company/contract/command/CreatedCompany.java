package ports.input.company.contract.command;

import java.util.List;
import java.util.UUID;
import ports.input.company.contract.Category;
import ports.input.company.contract.Company;

public record CreatedCompany(UUID id, UUID userId, Company company, List<Category> categories) {}
