package ports.input.company.contract.query;

import java.util.UUID;
import ports.input.company.contract.Company;

public record FoundCompany(UUID id, UUID userId, Company company) {}
