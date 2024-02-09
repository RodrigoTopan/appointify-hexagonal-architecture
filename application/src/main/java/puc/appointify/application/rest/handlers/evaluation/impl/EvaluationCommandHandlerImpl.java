package puc.appointify.application.rest.handlers.evaluation.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.evaluation.EvaluationCommandHandler;
import puc.appointify.application.rest.handlers.evaluation.contract.command.CreateEvaluationCommand;
import puc.appointify.application.rest.handlers.evaluation.contract.command.CreateEvaluationCommandResponse;
import puc.appointify.application.rest.handlers.evaluation.mapper.EvaluationMapper;
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
