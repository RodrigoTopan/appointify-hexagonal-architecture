package usecase.company.contract.command;

import jakarta.validation.constraints.NotNull;
import usecase.company.contract.Company;

import java.util.List;
import java.util.UUID;

public record CreateCompany(
        @NotNull UUID userId,
        Company company,
        List<UUID> categories
) {}


