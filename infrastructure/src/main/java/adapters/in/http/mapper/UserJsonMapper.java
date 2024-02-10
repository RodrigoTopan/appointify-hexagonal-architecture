package adapters.in.http.mapper;

import adapters.in.http.json.CreateUserRequest;
import adapters.in.http.json.CreateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import usecase.user.contract.command.CreateUser;
import usecase.user.contract.command.CreatedUser;

@Mapper(componentModel = "spring")
public interface UserJsonMapper {
    UserJsonMapper INSTANCE = Mappers.getMapper(UserJsonMapper.class);

    CreateUser toCreateUser(CreateUserRequest createUserRequest);

    CreateUserRequest toCreateUserRequest(CreateUser createUser);

    CreatedUser toCreatedUser(CreateUserResponse createUserResponse);

    CreateUserResponse toCreateUserResponse(CreateUser createUser);
}
