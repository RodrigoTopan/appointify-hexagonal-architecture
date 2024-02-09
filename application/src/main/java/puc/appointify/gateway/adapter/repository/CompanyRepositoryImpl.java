package puc.appointify.gateway.adapter.repository;

import entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import entity.Company;
import ports.output.repository.CategoryRepository;
import ports.output.repository.CompanyRepository;
import puc.appointify.gateway.database.entity.CategoryEntity;
import puc.appointify.gateway.database.entity.CompanyEntity;
import puc.appointify.gateway.database.jpa.CategoryJpaRepository;
import puc.appointify.gateway.database.jpa.CompanyJpaRepository;
import puc.appointify.gateway.database.mapper.CategoryDataAccessMapper;
import puc.appointify.gateway.database.mapper.CompanyDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


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
        return entities
                .stream()
                .map(CompanyDataAccessMapper::toDomain)
                .collect(Collectors.toList());
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