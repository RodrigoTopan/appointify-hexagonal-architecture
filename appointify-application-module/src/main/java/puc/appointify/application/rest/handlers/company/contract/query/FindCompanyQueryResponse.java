package puc.appointify.application.rest.handlers.company.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import puc.appointify.application.rest.handlers.company.contract.CompanyDTO;

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
