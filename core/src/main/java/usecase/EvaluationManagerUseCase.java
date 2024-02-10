package usecase;

import java.util.List;
import java.util.stream.Collectors;
import ports.input.EvaluationInputPort;
import ports.input.evaluation.contract.command.CreateEvaluation;
import ports.input.evaluation.contract.command.CreatedEvaluation;
import ports.input.evaluation.contract.query.FoundEvaluation;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.EvaluationRepository;
import usecase.mappers.EvaluationMapper;

public class EvaluationManagerUseCase implements EvaluationInputPort {
  private final EvaluationMapper evaluationMapper;
  private final CustomerRepository customerRepository;
  private final EmployeeRepository employeeRepository;
  private final EvaluationRepository evaluationRepository;

  public EvaluationManagerUseCase(
      EvaluationMapper evaluationMapper,
      CustomerRepository customerRepository,
      EmployeeRepository employeeRepository,
      EvaluationRepository evaluationRepository) {
    this.evaluationMapper = evaluationMapper;
    this.customerRepository = customerRepository;
    this.employeeRepository = employeeRepository;
    this.evaluationRepository = evaluationRepository;
  }

  @Override
  public CreatedEvaluation create(CreateEvaluation command) {
    var customer = customerRepository.findById(command.customerId());
    var employee = employeeRepository.findById(command.employeeId());
    var evaluation = customer.evaluateEmployee(command.rate(), command.comment(), employee);
    var savedEvaluation = evaluationRepository.save(evaluation);
    return evaluationMapper.evaluationToCreateEvaluationCommandResponse(savedEvaluation);
  }

  @Override
  public List<FoundEvaluation> findAll() {
    return evaluationRepository.findAll().stream()
        .map(evaluationMapper::evaluationToFindEvaluationQueryResponse)
        .collect(Collectors.toList());
  }
}
