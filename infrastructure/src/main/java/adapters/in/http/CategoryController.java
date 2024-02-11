package adapters.in.http;

import adapters.in.http.json.category.CreateCategoryRequest;
import adapters.in.http.mapper.CategoryJsonMapper;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.CategoryInputPort;
import ports.input.category.contract.command.CreatedCategory;
import ports.input.category.contract.query.FoundCategory;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryJsonMapper mapper;
  private final CategoryInputPort categoryInputPort;

  @GetMapping("/{id}")
  public ResponseEntity<FoundCategory> findById(@PathVariable UUID id) {
    return ResponseEntity.ok().body(categoryInputPort.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<FoundCategory>> findAll() {
    return ResponseEntity.ok().body(categoryInputPort.findAll());
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_COMPANY')")
  public ResponseEntity<CreatedCategory> create(@RequestBody @Valid CreateCategoryRequest request) {
    return ResponseEntity.ok().body(categoryInputPort.create(mapper.toCommand(request)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable UUID id) {
    categoryInputPort.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
