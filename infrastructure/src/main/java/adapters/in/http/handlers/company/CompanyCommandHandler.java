package adapters.in.http.handlers.company;

import adapters.in.http.handlers.company.contract.command.CreateCompanyCommand;
import adapters.in.http.handlers.company.contract.command.CreateCompanyCommandResponse;

import java.util.UUID;

public interface CompanyCommandHandler {
    CreateCompanyCommandResponse create(CreateCompanyCommand command);
    void deleteById(UUID id);
}
