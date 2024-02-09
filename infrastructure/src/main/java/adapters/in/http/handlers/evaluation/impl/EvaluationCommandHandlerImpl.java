package adapters.in.http.handlers.evaluation.impl;

import adapters.in.http.handlers.evaluation.EvaluationCommandHandler;
import adapters.in.http.handlers.evaluation.contract.command.CreateEvaluationCommand;
import adapters.in.http.handlers.evaluation.contract.command.CreateEvaluationCommandResponse;
import adapters.in.http.handlers.evaluation.mapper.EvaluationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.CustomerRepository;
import ports.output.repository.EmployeeRepository;
import ports.output.repository.EvaluationRepository;

@Component
@RequiredArgsConstructor
public class EvaluationCommandHandlerImpl implements EvaluationCommandHandler {
    private final EvaluationMapper evaluationMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final EvaluationRepository evaluationRepository;

    @Override
    public CreateEvaluationCommandResponse create(CreateEvaluationCommand command) {
        var customer = customerRepository.findById(command.getCustomerId());
        var employee = employeeRepository.findById(command.getEmployeeId());

        //var customerSavedEvaluations = evaluationRepository.findByCustomerId(customer.getId());

        var evaluation = customer.evaluateEmployee(command.getRate(), command.getComment(), employee);
        var savedEvaluation = evaluationRepository.save(evaluation);
        return evaluationMapper.evaluationToCreateEvaluationCommandResponse(savedEvaluation);
    }
}
