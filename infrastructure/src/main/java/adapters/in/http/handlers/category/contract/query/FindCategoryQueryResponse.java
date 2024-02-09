package adapters.in.http.handlers.category.contract.query;

import adapters.in.http.handlers.category.contract.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindCategoryQueryResponse {
    private UUID id;
    private String name;
    private String image;
    private List<CompanyDTO> companies;
}

