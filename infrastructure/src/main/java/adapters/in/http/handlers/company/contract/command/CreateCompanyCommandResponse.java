package adapters.in.http.handlers.company.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import adapters.in.http.handlers.company.contract.CategoryDTO;
import adapters.in.http.handlers.company.contract.CompanyDTO;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyCommandResponse {

    private UUID id;
    private UUID userId;
    private CompanyDTO company;
    private List<CategoryDTO> categories;
}
