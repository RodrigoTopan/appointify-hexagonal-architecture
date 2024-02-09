package puc.appointify.application.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ports.input.CategoryInputPort;
import ports.output.repository.CategoryRepository;
import ports.output.repository.UserRepository;
import puc.appointify.application.rest.handlers.user.UserQueryHandler;
import puc.appointify.application.rest.handlers.user.impl.UserQueryHandlerImpl;
import puc.appointify.application.rest.handlers.user.mapper.UserMapper;
import service.CategoryDomainService;

@Configuration
@RequiredArgsConstructor
public class InputPortsConfiguration {

    @Bean
    public CategoryInputPort userQueryHandler(CategoryRepository categoryRepository) {
        return new CategoryDomainService(categoryRepository);
    }

}
