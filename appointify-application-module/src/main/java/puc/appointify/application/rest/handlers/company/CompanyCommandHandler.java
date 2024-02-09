package puc.appointify.application.rest.handlers.company;

import puc.appointify.application.rest.handlers.company.contract.command.CreateCompanyCommand;
import puc.appointify.application.rest.handlers.company.contract.command.CreateCompanyCommandResponse;

import java.util.UUID;

public interface CompanyCommandHandler {
    CreateCompanyCommandResponse create(CreateCompanyCommand command);
    void deleteById(UUID id);
}
