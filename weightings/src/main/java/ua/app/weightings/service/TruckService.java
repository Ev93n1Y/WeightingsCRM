package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.TruckDto;
import ua.app.weightings.repository.TruckRepository;
import ua.app.weightings.service.converter.TruckConverter;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TruckService implements CrudService<TruckDto>{
    private final TruckRepository repository;
    private final TruckConverter converter;
    @Override
    public List<TruckDto> findAll() {
        return repository.findAll(Sort.by("truck"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TruckDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public TruckDto save(TruckDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public TruckDto save(UUID id, TruckDto dto) {
        return converter.toDto(repository.findById(id)
                .map(p -> repository.save(converter.toDao(dto)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
