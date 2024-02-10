package usecase.schedules.contract;

import java.util.Date;
import java.util.UUID;

public record Schedule(UUID id, Date startDate, Date endDate) {}
