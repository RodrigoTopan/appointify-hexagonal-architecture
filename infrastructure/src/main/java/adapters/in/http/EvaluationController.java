package adapters.in.http;

import usecase.evaluation.contract.command.CreateEvaluationCommand;
import usecase.evaluation.contract.command.CreateEvaluationCommandResponse;
import usecase.evaluation.contract.query.FindEvaluationQueryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.EvaluationInputPort;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationInputPort evaluationInputPort;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<CreateEvaluationCommandResponse> create(
            @RequestBody @Valid CreateEvaluationCommand command) {
        return ResponseEntity.ok()
                .body(evaluationInputPort.create(command));
    }

    @GetMapping
    public ResponseEntity<List<FindEvaluationQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(evaluationInputPort.findAll());
    }
}
