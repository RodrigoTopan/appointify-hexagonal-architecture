package adapters.in.http.mapper;

import adapters.in.http.json.category.CreateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.category.contract.command.CreateCategory;

@Mapper(componentModel = "spring")
public interface CategoryJsonMapper {
  CategoryJsonMapper INSTANCE = Mappers.getMapper(CategoryJsonMapper.class);

  CreateCategory toCommand(CreateCategoryRequest request);
}
