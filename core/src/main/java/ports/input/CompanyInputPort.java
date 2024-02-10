package ports.input;

import usecase.company.contract.command.CreateCompany;
import usecase.company.contract.command.CreateCompanyResponse;
import usecase.company.contract.query.FindCompanyResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyInputPort {
    CreateCompanyResponse create(CreateCompany command);
    void deleteById(UUID id);

    List<FindCompanyResponse> findAll();

    FindCompanyResponse findById(UUID id);
}
