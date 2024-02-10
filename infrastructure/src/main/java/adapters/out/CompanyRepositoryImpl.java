package adapters.out;

import adapters.out.entity.CompanyEntity;
import adapters.out.jpa.CompanyJpaRepository;
import adapters.out.mapper.CompanyDataAccessMapper;
import domain.entity.Company;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.CompanyRepository;

@Component
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
  private final CompanyJpaRepository jpaRepository;

  @Override
  public Company save(Company domain) {
    var entity = CompanyDataAccessMapper.toEntity(domain);
    var savedEntity = jpaRepository.save(entity);
    return CompanyDataAccessMapper.toDomain(savedEntity);
  }

  @Override
  public List<Company> findAll() {
    List<CompanyEntity> entities = jpaRepository.findAll();
    return entities.stream().map(CompanyDataAccessMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public Company findById(UUID id) {
    var entity = jpaRepository.findById(id).orElse(null);
    if (entity == null) return null;
    return CompanyDataAccessMapper.toDomain(entity);
  }

  @Override
  public void deleteById(UUID id) {
    jpaRepository.deleteById(id);
  }
}
