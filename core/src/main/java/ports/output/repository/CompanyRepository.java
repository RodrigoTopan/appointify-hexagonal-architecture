package ports.output.repository;

import domain.entity.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyRepository {
    Company save(Company customer);

    List<Company> findAll();

    Company findById(UUID id);

    void deleteById(UUID id);
}
