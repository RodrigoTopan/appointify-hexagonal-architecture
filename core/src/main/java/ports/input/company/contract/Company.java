package ports.input.company.contract;


public record Company(
        String name,
        String description,
        String governmentId,
        String image
) {
}


