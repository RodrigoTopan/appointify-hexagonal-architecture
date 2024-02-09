package ports.input;

import java.util.List;
import java.util.UUID;

public interface CompanyInputPort {
    CompanyInputPort create(CompanyInputPort company);
    void delete(UUID companyId);

    List<CompanyInputPort> findAll();

    CompanyInputPort find(UUID companyId);
}
