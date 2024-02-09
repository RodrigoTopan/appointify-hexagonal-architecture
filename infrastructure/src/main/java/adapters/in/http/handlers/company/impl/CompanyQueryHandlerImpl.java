package adapters.in.http.handlers.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import adapters.in.http.handlers.company.contract.query.FindCompanyQueryResponse;
import adapters.in.http.handlers.company.mapper.CompanyMapper;
import ports.output.repository.CompanyRepository;
import adapters.in.http.handlers.company.CompanyQueryHandler;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyQueryHandlerImpl implements CompanyQueryHandler {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;

    @Override
    public List<FindCompanyQueryResponse> findAll() {
        var customers = companyRepository.findAll();
        return customers.stream()
                .map(companyMapper::companyToFindCompanyQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCompanyQueryResponse findById(UUID id) {
        var customer = companyRepository.findById(id);
        return companyMapper.companyToFindCompanyQueryResponse(customer);
    }
}
