package puc.appointify.application.rest.handlers.category;

import puc.appointify.application.rest.handlers.category.contract.query.FindCategoryQueryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryQueryHandler {
    List<FindCategoryQueryResponse> findAll();
    FindCategoryQueryResponse findById(UUID id);
}
