package adapters.in.http.mapper;

import adapters.in.http.json.customer.CreateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.customer.contract.command.CreateCustomer;

@Mapper(componentModel = "spring")
public interface CustomerJsonMapper {
  CustomerJsonMapper INSTANCE = Mappers.getMapper(CustomerJsonMapper.class);

  CreateCustomer toCommand(CreateCustomerRequest request);
}
