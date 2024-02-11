package adapters.in.http.mapper;

import adapters.in.http.json.offeredservice.CreateOfferedServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.offeredservice.contract.command.CreateOfferedService;

@Mapper(componentModel = "spring")
public interface OfferedServiceJsonMapper {
  OfferedServiceJsonMapper INSTANCE = Mappers.getMapper(OfferedServiceJsonMapper.class);

  CreateOfferedService toCommand(CreateOfferedServiceRequest request);
}
