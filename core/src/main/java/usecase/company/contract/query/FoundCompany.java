package usecase.company.contract.query;

import usecase.company.contract.Company;

import java.util.UUID;
public record FoundCompany(
        UUID id,
        UUID userId,
        Company company
) {}

