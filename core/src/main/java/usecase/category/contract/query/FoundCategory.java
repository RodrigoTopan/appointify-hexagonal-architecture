package usecase.category.contract.query;

import usecase.category.contract.Company;

import java.util.List;
import java.util.UUID;

public record FoundCategory(
        UUID id,
        String name,
        String image,
        List<Company> companies
) {}

