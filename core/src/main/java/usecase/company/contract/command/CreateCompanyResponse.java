package usecase.company.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import usecase.company.contract.Category;
import usecase.company.contract.Company;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyResponse {

    private UUID id;
    private UUID userId;
    private Company company;
    private List<Category> categories;
}
