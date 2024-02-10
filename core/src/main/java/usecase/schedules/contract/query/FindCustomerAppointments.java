package usecase.schedules.contract.query;

import java.util.UUID;

public record FindCustomerAppointments(
        UUID customerId
) {
}
