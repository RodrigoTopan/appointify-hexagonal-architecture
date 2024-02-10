package domain.entity;

import domain.valueobject.CompanyDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Company {

    private final UUID id;
    private final User user;
    private final CompanyDetails companyDetails;
    private final List<Employee> employees = new ArrayList<>();

    private final List<Category> categories = new ArrayList<>();

    public Company(User user, CompanyDetails companyDetails) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.companyDetails = companyDetails;
    }

    public Company(User user, CompanyDetails companyDetails, List<Employee> employees, List<Category> categories) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.companyDetails = companyDetails;
        this.employees.addAll(employees);
        this.categories.addAll(categories);
    }

    public Company(UUID id, User user, CompanyDetails companyDetails, List<Employee> employees, List<Category> categories) {
        this.id = id;
        this.user = user;
        this.companyDetails = companyDetails;
        this.employees.addAll(employees);
        this.categories.addAll(categories);
    }

    public Employee createEmployee(User user) {
        var employee = new Employee(user, this);
        employees.add(employee);
        return employee;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public CompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Category> getCategories() {
        return categories;
    }
}