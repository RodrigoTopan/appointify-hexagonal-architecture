package adapters.in.http;

import usecase.evaluation.contract.command.CreateEvaluation;
import usecase.evaluation.contract.command.CreateEvaluationResult;
import usecase.evaluation.contract.query.FindEvaluationResult;
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
    public ResponseEntity<CreateEvaluationResult> create(
            @RequestBody @Valid CreateEvaluation command) {
        return ResponseEntity.ok()
                .body(evaluationInputPort.create(command));
    }

    @GetMapping
    public ResponseEntity<List<FindEvaluationResult>> findAll() {
        return ResponseEntity.ok()
                .body(evaluationInputPort.findAll());
    }
}
