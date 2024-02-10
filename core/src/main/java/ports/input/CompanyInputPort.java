package ports.input;

import java.util.List;
import java.util.UUID;
import ports.input.company.contract.command.CreateCompany;
import ports.input.company.contract.command.CreatedCompany;
import ports.input.company.contract.query.FoundCompany;

public interface CompanyInputPort {
  CreatedCompany create(CreateCompany command);

  void deleteById(UUID id);

  List<FoundCompany> findAll();

  FoundCompany findById(UUID id);
}
