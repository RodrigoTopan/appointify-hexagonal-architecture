package usecase.company.contract.command;

import usecase.company.contract.Category;
import usecase.company.contract.Company;

import java.util.List;
import java.util.UUID;

public record CreatedCompany(
        UUID id,
        UUID userId,
        Company company,
        List<Category> categories
) {}

