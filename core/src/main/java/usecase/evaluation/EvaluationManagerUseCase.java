package usecase.evaluation;

import usecase.evaluation.contract.command.CreateEvaluationCommand;
import usecase.evaluation.contract.command.CreateEvaluationCommandResponse;
import usecase.evaluation.contract.query.FindEvaluationQueryResponse;
import usecase.evaluation.mapper.EvaluationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.EvaluationInputPort;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.EvaluationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EvaluationManagerUseCase implements EvaluationInputPort {
    private final EvaluationMapper evaluationMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final EvaluationRepository evaluationRepository;

    @Override
    public CreateEvaluationCommandResponse create(CreateEvaluationCommand command) {
        var customer = customerRepository.findById(command.getCustomerId());
        var employee = employeeRepository.findById(command.getEmployeeId());
        var evaluation = customer.evaluateEmployee(command.getRate(), command.getComment(), employee);
        var savedEvaluation = evaluationRepository.save(evaluation);
        return evaluationMapper.evaluationToCreateEvaluationCommandResponse(savedEvaluation);
    }

    @Override
    public List<FindEvaluationQueryResponse> findAll() {
        return evaluationRepository.findAll()
                .stream()
                .map(evaluationMapper::evaluationToFindEvaluationQueryResponse)
                .collect(Collectors.toList());
    }
}
