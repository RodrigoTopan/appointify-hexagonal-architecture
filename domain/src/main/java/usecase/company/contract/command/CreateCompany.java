package usecase.company.contract.command;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import usecase.company.contract.Company;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompany {
    @NotNull
    private UUID userId;
    @Valid
    private Company company;

    private List<UUID> categories;
}

