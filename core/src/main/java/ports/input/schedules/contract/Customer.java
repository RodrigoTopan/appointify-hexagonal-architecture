package ports.input.schedules.contract;

import java.util.UUID;

public record Customer(UUID id, String name, String email) {}
