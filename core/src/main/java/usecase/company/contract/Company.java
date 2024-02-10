package usecase.company.contract;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String governmentId;
    private String image;
}

