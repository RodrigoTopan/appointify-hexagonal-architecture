package adapters.in.http.handlers.category;

import adapters.in.http.handlers.category.contract.query.FindCategoryQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryQueryHandler {
    List<FindCategoryQueryResponse> findAll();
    FindCategoryQueryResponse findById(UUID id);
}
