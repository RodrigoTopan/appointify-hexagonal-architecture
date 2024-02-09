package puc.appointify.application.rest.handlers.employee;

import puc.appointify.application.rest.handlers.employee.contract.query.FindEmployeeQueryResponse;

import java.util.List;

public interface EmployeeQueryHandler {
    List<FindEmployeeQueryResponse> findAll();
}
