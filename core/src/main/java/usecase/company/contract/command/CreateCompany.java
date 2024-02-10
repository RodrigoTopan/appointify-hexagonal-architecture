package usecase.company.contract.command;

;
import usecase.company.contract.Company;

import java.util.List;
import java.util.UUID;

public record CreateCompany(
         UUID userId,
        Company company,
        List<UUID> categories
) {}


