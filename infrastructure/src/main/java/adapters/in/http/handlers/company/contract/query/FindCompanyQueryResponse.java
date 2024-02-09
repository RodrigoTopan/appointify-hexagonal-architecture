package adapters.in.http.handlers.company.contract.query;

import adapters.in.http.handlers.company.contract.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindCompanyQueryResponse {

    private UUID id;
    private UUID userId;
    private CompanyDTO company;
}
