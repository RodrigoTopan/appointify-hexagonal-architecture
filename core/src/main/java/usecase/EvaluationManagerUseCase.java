package usecase;

import usecase.evaluation.contract.command.CreateEvaluation;
import usecase.evaluation.contract.command.CreatedEvaluation;
import usecase.evaluation.contract.query.FoundEvaluation;
import usecase.evaluation.mapper.EvaluationMapper;
import ports.input.EvaluationInputPort;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.EvaluationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EvaluationManagerUseCase implements EvaluationInputPort {
    private final EvaluationMapper evaluationMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final EvaluationRepository evaluationRepository;

    public EvaluationManagerUseCase(EvaluationMapper evaluationMapper, CustomerRepository customerRepository, EmployeeRepository employeeRepository, EvaluationRepository evaluationRepository) {
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
        return evaluationRepository.findAll()
                .stream()
                .map(evaluationMapper::evaluationToFindEvaluationQueryResponse)
                .collect(Collectors.toList());
    }
}
