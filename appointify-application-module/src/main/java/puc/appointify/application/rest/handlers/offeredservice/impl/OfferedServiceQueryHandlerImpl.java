package puc.appointify.application.rest.handlers.offeredservice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.offeredservice.OfferedServiceQueryHandler;
import puc.appointify.application.rest.handlers.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import puc.appointify.application.rest.handlers.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import ports.output.repository.OfferedServiceRepository;
import puc.appointify.application.rest.handlers.offeredservice.mapper.OfferedServiceMapper;

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
