package adapters.in.http.mapper;

import adapters.in.http.json.employee.CreateEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.employee.contract.command.CreateEmployee;

@Mapper(componentModel = "spring")
public interface EmployeeJsonMapper {
  EmployeeJsonMapper INSTANCE = Mappers.getMapper(EmployeeJsonMapper.class);

  CreateEmployee toCommand(CreateEmployeeRequest request);
}
