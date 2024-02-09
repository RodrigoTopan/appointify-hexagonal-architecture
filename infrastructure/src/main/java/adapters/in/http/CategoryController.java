package adapters.in.http;

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
import adapters.in.http.handlers.category.CategoryCommandHandler;
import adapters.in.http.handlers.category.CategoryQueryHandler;
import adapters.in.http.handlers.category.contract.command.CreateCategoryCommand;
import adapters.in.http.handlers.category.contract.command.CreateCategoryCommandResponse;
import adapters.in.http.handlers.category.contract.query.FindCategoryQueryResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryCommandHandler categoryCommandHandler;
    private final CategoryQueryHandler categoryQueryHandler;


    @GetMapping("/{id}")
    public ResponseEntity<FindCategoryQueryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(categoryQueryHandler.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<FindCategoryQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(categoryQueryHandler.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    public ResponseEntity<CreateCategoryCommandResponse> create(
            @RequestBody @Valid CreateCategoryCommand command) {
        return ResponseEntity.ok()
                .body(categoryCommandHandler.create(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        categoryCommandHandler.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
