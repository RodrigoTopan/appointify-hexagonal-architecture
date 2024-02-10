package adapters.in.http.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ports.input.CategoryInputPort;
import ports.input.CompanyInputPort;
import ports.input.CustomerInputPort;
import ports.input.EmployeeInputPort;
import ports.input.EvaluationInputPort;
import ports.input.OfferedServiceInputPort;
import ports.input.ScheduleInputPort;
import ports.input.UserInputPort;
import ports.output.repository.CategoryRepository;
import ports.output.repository.CompanyRepository;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.EvaluationRepository;
import ports.output.repository.OfferedServiceRepository;
import ports.output.repository.ScheduleRepository;
import ports.output.repository.UserRepository;
import usecase.CategoryManagerUseCase;
import usecase.CompanyManagerUseCase;
import usecase.CustomerManagerUseCase;
import usecase.EmployeeManagerUseCase;
import usecase.EvaluationManagerUseCase;
import usecase.OfferedServiceManagerUseCase;
import usecase.ScheduleManagerUseCase;
import usecase.UserManagerUseCase;
import usecase.mappers.CategoryMapper;
import usecase.mappers.CompanyMapper;
import usecase.mappers.CustomerMapper;
import usecase.mappers.EmployeeMapper;
import usecase.mappers.EvaluationMapper;
import usecase.mappers.OfferedServiceMapper;
import usecase.mappers.ScheduleMapper;
import usecase.mappers.UserMapper;

@Configuration
@RequiredArgsConstructor
public class InputPortsConfiguration {

  @Bean
  public CategoryInputPort categoryInputPort(CategoryRepository categoryRepository) {
    return new CategoryManagerUseCase(new CategoryMapper(), categoryRepository);
  }

  @Bean
  public CompanyInputPort companyInputPort(
      CompanyRepository companyRepository,
      CategoryRepository categoryRepository,
      UserRepository userRepository) {
    return new CompanyManagerUseCase(
        new CompanyMapper(), companyRepository, categoryRepository, userRepository);
  }

  @Bean
  public CustomerInputPort customerInputPort(
      CustomerRepository customerRepository, UserRepository userRepository) {
    return new CustomerManagerUseCase(new CustomerMapper(), customerRepository, userRepository);
  }

  @Bean
  public EmployeeInputPort employeeInputPort(
      CompanyRepository companyRepository,
      EmployeeRepository employeeRepository,
      UserRepository userRepository) {
    return new EmployeeManagerUseCase(
        new EmployeeMapper(), companyRepository, employeeRepository, userRepository);
  }

  @Bean
  public EvaluationInputPort evaluationInputPort(
      CustomerRepository customerRepository,
      EmployeeRepository employeeRepository,
      EvaluationRepository evaluationRepository) {
    return new EvaluationManagerUseCase(
        new EvaluationMapper(), customerRepository, employeeRepository, evaluationRepository);
  }

  @Bean
  public OfferedServiceInputPort offeredServiceInputPort(
      CompanyRepository companyRepository, OfferedServiceRepository offeredServiceRepository) {
    return new OfferedServiceManagerUseCase(
        new OfferedServiceMapper(), companyRepository, offeredServiceRepository);
  }

  @Bean
  public ScheduleInputPort scheduleInputPort(
      CustomerRepository customerRepository,
      EmployeeRepository employeeRepository,
      OfferedServiceRepository offeredServiceRepository,
      ScheduleRepository scheduleRepository) {
    return new ScheduleManagerUseCase(
        new ScheduleMapper(),
        customerRepository,
        employeeRepository,
        offeredServiceRepository,
        scheduleRepository);
  }

  @Bean
  public UserInputPort userInputPort(UserRepository userRepository) {
    return new UserManagerUseCase(new UserMapper(), userRepository);
  }
}
