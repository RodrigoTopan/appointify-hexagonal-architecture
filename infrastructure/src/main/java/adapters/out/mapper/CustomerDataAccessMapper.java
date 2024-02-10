package adapters.out.mapper;

import adapters.out.entity.CustomerEntity;
import domain.entity.Customer;
import domain.entity.Evaluation;
import domain.entity.Schedule;
import domain.entity.User;
import domain.valueobject.Email;
import domain.valueobject.Password;
import domain.valueobject.UserRole;
import domain.valueobject.Username;
import adapters.out.entity.UserEntity;

import java.util.List;

public class CustomerDataAccessMapper {
    public static CustomerEntity toEntity(Customer customer) {
        if (customer == null) return null;
        var user = customer.getUser();
        return CustomerEntity
                .builder()
                .id(customer.getId())
                .user(UserEntity
                        .builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .username(user.getUsername().getValue())
                        .email(user.getEmail().getValue())
                        .role(user.getRole().getValue())
                        .build())
                .build();
    }

    public static Customer toDomain(CustomerEntity entity) {
        if (entity == null) return null;
        var userEntity = entity.getUser();
        User user = null;
        if (userEntity != null) {
            user = new User(
                    userEntity.getId(),
                    userEntity.getFirstName(),
                    userEntity.getLastName(),
                    new Username(userEntity.getUsername()),
                    new Email(userEntity.getEmail()),
                    new Password(userEntity.getPassword()),
                    UserRole.valueOf(userEntity.getRole()));
        }

        List<Schedule> schedules = entity.getSchedules().stream()
                .map(ScheduleDataAccessMapper::toDomain).toList();

        List<Evaluation> evaluations = entity.getEvaluations().stream()
                .map(EvaluationDataAccessMapper::toDomain).toList();

        return new Customer(entity.getId(), user, schedules, evaluations);
    }
}