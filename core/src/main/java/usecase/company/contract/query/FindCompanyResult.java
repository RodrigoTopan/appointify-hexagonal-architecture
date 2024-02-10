package usecase.company.contract.query;

import usecase.company.contract.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindCompanyResult {

    private UUID id;
    private UUID userId;
    private Company company;
}
