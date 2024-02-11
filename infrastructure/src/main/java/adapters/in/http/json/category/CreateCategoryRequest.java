package adapters.in.http.json.category;

import jakarta.validation.constraints.NotEmpty;

public record CreateCategoryRequest(@NotEmpty String name, String image) {}
