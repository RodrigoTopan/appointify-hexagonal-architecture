package puc.appointify.gateway.database.mapper;

import entity.Category;
import puc.appointify.gateway.database.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CategoryDataAccessMapper {

    public static CategoryEntity toEntity(Category category) {
        if (category == null) return null;
        return CategoryEntity
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }

    public static Category toDomain(CategoryEntity entity) {
        if (entity == null) return null;

        var entityCompanies = entity.getCompanies();
        if (entityCompanies != null) {
            var companies = entity.getCompanies()
                    .stream()
                    .map(CompanyDataAccessMapper::toDomain)
                    .collect(Collectors.toList());

            return new Category(entity.getId(), entity.getName(), entity.getImage(), companies);
        }

        return new Category(entity.getId(), entity.getName(), entity.getImage(), new ArrayList<>());
    }
}
