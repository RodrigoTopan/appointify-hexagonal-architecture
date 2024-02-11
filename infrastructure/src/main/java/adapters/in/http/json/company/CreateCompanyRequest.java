package adapters.in.http.json.company;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record CreateCompanyRequest(
    @NotNull UUID userId, @Valid Company company, List<UUID> categories) {}
