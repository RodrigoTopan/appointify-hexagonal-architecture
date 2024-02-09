package ports.output.repository;

import entity.OfferedService;

import java.util.List;
import java.util.UUID;

public interface OfferedServiceRepository {
    OfferedService save(OfferedService offeredService);

    List<OfferedService> findAll();

    OfferedService findById(UUID id);

    List<OfferedService>  findAllByCompanyId(UUID id);

    void deleteById(UUID id);
}
