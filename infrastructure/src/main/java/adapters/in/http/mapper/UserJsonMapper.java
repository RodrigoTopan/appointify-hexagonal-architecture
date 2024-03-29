package adapters.in.http.mapper;

import adapters.in.http.json.user.CreateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.user.contract.command.CreateUser;

@Mapper(componentModel = "spring")
public interface UserJsonMapper {
  UserJsonMapper INSTANCE = Mappers.getMapper(UserJsonMapper.class);

  CreateUser toCommand(CreateUserRequest createUserRequest);
}
