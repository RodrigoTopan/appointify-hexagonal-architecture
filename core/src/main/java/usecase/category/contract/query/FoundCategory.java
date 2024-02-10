package usecase.category.contract.query;

import usecase.category.contract.CompanyDTO;
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
public class FoundCategory {
    private UUID id;
    private String name;
    private String image;
    private List<CompanyDTO> companies;
}

