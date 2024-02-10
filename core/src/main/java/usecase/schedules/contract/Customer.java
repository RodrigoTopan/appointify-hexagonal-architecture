package usecase.schedules.contract;

import java.util.UUID;

public record Customer (
     UUID id,
     String name,
     String email
){}
