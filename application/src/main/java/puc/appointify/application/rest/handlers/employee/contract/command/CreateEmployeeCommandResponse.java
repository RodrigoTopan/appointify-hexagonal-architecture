package puc.appointify.application.rest.handlers.employee.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeCommandResponse {

    private UUID id;
    private UUID userId;
    private UUID companyId;
}
