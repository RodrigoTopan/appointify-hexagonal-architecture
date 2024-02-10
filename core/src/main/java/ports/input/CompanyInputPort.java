package ports.input;

import usecase.company.contract.command.CreateCompany;
import usecase.company.contract.command.CreateCompanyResult;
import usecase.company.contract.query.FindCompanyResult;

import java.util.List;
import java.util.UUID;

public interface CompanyInputPort {
    CreateCompanyResult create(CreateCompany command);
    void deleteById(UUID id);

    List<FindCompanyResult> findAll();

    FindCompanyResult findById(UUID id);
}
