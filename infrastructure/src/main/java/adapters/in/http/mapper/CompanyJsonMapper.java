package adapters.in.http.mapper;

import adapters.in.http.json.company.CreateCompanyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ports.input.company.contract.command.CreateCompany;

@Mapper(componentModel = "spring")
public interface CompanyJsonMapper {
  CompanyJsonMapper INSTANCE = Mappers.getMapper(CompanyJsonMapper.class);

  CreateCompany toCommand(CreateCompanyRequest request);
}
