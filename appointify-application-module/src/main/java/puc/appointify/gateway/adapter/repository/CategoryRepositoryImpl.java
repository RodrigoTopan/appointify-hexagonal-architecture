package puc.appointify.gateway.adapter.repository;

import entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.CategoryRepository;
import puc.appointify.gateway.database.entity.CategoryEntity;
import puc.appointify.gateway.database.jpa.CategoryJpaRepository;
import puc.appointify.gateway.database.mapper.CategoryDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryJpaRepository jpaRepository;

    @Override
    public Category save(Category domain) {
        var entity = CategoryDataAccessMapper.toEntity(domain);
        var savedEntity = jpaRepository.save(entity);
        return CategoryDataAccessMapper.toDomain(savedEntity);
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> entities = jpaRepository.findAll();
        return entities
                .stream()
                .map(CategoryDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> findAllById(List<UUID> ids) {
        List<CategoryEntity> entities = jpaRepository.findAllById(ids);
        return entities
                .stream()
                .map(CategoryDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Category findById(UUID id) {
        var entity = jpaRepository.findById(id).orElse(null);
        if (entity == null) return null;
        return CategoryDataAccessMapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}