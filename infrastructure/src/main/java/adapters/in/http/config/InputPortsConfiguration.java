package adapters.in.http.config;

import adapters.out.UserRepositoryImpl;
import adapters.out.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ports.input.CategoryInputPort;
import ports.input.UserInputPort;
import ports.output.repository.CategoryRepository;
import ports.output.repository.UserRepository;
import service.CategoryDomainService;
import service.UserDomainService;

@Configuration
@RequiredArgsConstructor
public class InputPortsConfiguration {

    @Bean
    public CategoryInputPort userQueryHandler(CategoryRepository categoryRepository) {
        return new CategoryDomainService(categoryRepository);
    }

    @Bean
    public UserInputPort userInputPort(UserRepository userRepository) {
        return new UserDomainService(userRepository);
    }

}
