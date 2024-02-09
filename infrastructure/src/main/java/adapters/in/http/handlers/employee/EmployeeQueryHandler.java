package adapters.in.http.handlers.employee;

import adapters.in.http.handlers.employee.contract.query.FindEmployeeQueryResponse;

import java.util.List;

public interface EmployeeQueryHandler {
    List<FindEmployeeQueryResponse> findAll();
}
