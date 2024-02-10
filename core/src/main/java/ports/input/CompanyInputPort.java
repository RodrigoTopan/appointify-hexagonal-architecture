package ports.input;

import usecase.company.contract.command.CreateCompany;
import usecase.company.contract.command.CreatedCompany;
import usecase.company.contract.query.FoundCompany;

import java.util.List;
import java.util.UUID;

public interface CompanyInputPort {
    CreatedCompany create(CreateCompany command);
    void deleteById(UUID id);

    List<FoundCompany> findAll();

    FoundCompany findById(UUID id);
}
