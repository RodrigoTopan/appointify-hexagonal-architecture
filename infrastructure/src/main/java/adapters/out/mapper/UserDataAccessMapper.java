package adapters.out.mapper;

import entity.User;
import entity.valueobject.Email;
import entity.valueobject.Password;
import entity.valueobject.UserRole;
import entity.valueobject.Username;
import adapters.out.entity.UserEntity;

public class UserDataAccessMapper {

    public static UserEntity toEntity(User user) {
        if (user == null) return null;

        return UserEntity
                .builder()
                .id(user.getId())
                .email(user.getEmail().getValue())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername().getValue())
                .password(user.getPassword().getValue())
                .role(user.getRole().getValue())
                .build();
    }

    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                new Username(userEntity.getUsername()),
                new Email(userEntity.getEmail()),
                new Password(userEntity.getPassword()),
                UserRole.valueOf(userEntity.getRole()));
    }
}