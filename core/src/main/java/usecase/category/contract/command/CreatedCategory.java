package usecase.category.contract.command;


;

import java.util.UUID;

public record CreatedCategory(
         UUID id,
         String name,
        String image
) {}


