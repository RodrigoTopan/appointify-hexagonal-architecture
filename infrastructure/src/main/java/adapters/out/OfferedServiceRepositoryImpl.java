package adapters.out;

import adapters.out.postgres.entity.OfferedServiceEntity;
import adapters.out.postgres.jpa.OfferedServiceJpaRepository;
import adapters.out.postgres.mapper.OfferedServiceDataAccessMapper;
import entity.OfferedService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.OfferedServiceRepository;

@Component
@RequiredArgsConstructor
public class OfferedServiceRepositoryImpl implements OfferedServiceRepository {
  private final OfferedServiceJpaRepository jpaRepository;

  @Override
  public OfferedService save(OfferedService domain) {
    var entity = OfferedServiceDataAccessMapper.toEntity(domain);
    var savedEntity = jpaRepository.save(entity);
    return OfferedServiceDataAccessMapper.toDomain(savedEntity);
  }

  @Override
  public List<OfferedService> findAll() {
    List<OfferedServiceEntity> entities = jpaRepository.findAll();
    return entities.stream()
        .map(OfferedServiceDataAccessMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public OfferedService findById(UUID id) {
    var entity = jpaRepository.findById(id);
    return entity.map(OfferedServiceDataAccessMapper::toDomain).orElse(null);
  }

  @Override
  public List<OfferedService> findAllByCompanyId(UUID companyId) {
    List<OfferedServiceEntity> entities = jpaRepository.findAllByCompanyId(companyId);
    return entities.stream()
        .map(OfferedServiceDataAccessMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(UUID id) {
    jpaRepository.deleteById(id);
  }
}
