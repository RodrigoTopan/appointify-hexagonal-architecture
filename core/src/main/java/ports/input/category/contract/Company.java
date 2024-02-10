package ports.input.category.contract;


import java.util.UUID;

public record Company(
        UUID id,
        String name,
        String description,
        String image
) {
}

