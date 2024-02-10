package usecase.company.contract;


public record Company(
        String name,
        String description,
        String governmentId,
        String image
) {
}


