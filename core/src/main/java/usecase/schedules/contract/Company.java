package usecase.schedules.contract;

import java.util.UUID;

public record Company (
     UUID id,
     String name,
     String governmentId
){}
