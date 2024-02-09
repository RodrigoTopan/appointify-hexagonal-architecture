package adapters.in.http.handlers.offeredservice.impl;

import adapters.in.http.handlers.offeredservice.OfferedServiceQueryHandler;
import adapters.in.http.handlers.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import adapters.in.http.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.OfferedServiceRepository;
import adapters.in.http.handlers.offeredservice.mapper.OfferedServiceMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferedServiceQueryHandlerImpl implements OfferedServiceQueryHandler {
    private final OfferedServiceMapper mapper;
    private final OfferedServiceRepository repository;

    @Override
    public List<FindOfferedServiceQueryResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindOfferedServiceQueryResponse findById(UUID id) {
        var offeredService = repository.findById(id);
        return mapper.offeredServiceToFindOfferedServiceQueryResponse(offeredService);
    }

    @Override
    public List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query) {
        return repository.findAll()
                .stream()
                .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
                .collect(Collectors.toList());
    }
}
