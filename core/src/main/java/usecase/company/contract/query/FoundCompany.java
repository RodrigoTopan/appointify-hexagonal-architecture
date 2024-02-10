package usecase.company.contract.query;

import usecase.company.contract.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import java.util.UUID;

public record FoundCompany(
        UUID id,
        UUID userId,
        Company company
) {}

