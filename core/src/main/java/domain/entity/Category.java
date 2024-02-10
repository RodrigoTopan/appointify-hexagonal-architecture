package domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {

    private UUID id;
    private final String name;
    private final String image;

    private final List<Company> companies = new ArrayList<>();

    public Category(String name, String image) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.image = image;
    }

    public Category(UUID id, String name, String image, List<Company> companies) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.companies.addAll(companies);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
