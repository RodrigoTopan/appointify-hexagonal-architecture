package adapters.in.http;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.EvaluationInputPort;
import ports.input.evaluation.contract.command.CreateEvaluation;
import ports.input.evaluation.contract.command.CreatedEvaluation;
import ports.input.evaluation.contract.query.FoundEvaluation;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

  private final EvaluationInputPort evaluationInputPort;

  @PostMapping
  @PreAuthorize("hasRole('ROLE_CUSTOMER')")
  public ResponseEntity<CreatedEvaluation> create(@RequestBody @Valid CreateEvaluation command) {
    return ResponseEntity.ok().body(evaluationInputPort.create(command));
  }

  @GetMapping
  public ResponseEntity<List<FoundEvaluation>> findAll() {
    return ResponseEntity.ok().body(evaluationInputPort.findAll());
  }
}
