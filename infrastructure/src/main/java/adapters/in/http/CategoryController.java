package adapters.in.http;

import usecase.category.contract.command.CreateCategoryCommand;
import usecase.category.contract.command.CreateCategoryCommandResponse;
import usecase.category.contract.query.FindCategoryQueryResponse;
import jakarta.validation.Valid;
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

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryInputPort categoryInputPort;


    @GetMapping("/{id}")
    public ResponseEntity<FindCategoryQueryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(categoryInputPort.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<FindCategoryQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(categoryInputPort.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateCategoryCommandResponse> create(
            @RequestBody @Valid CreateCategoryCommand command) {
        return ResponseEntity.ok()
                .body(categoryInputPort.create(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        categoryInputPort.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
