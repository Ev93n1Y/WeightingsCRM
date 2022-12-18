package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.StatusDto;
import ua.app.weightings.repository.StatusRepository;
import ua.app.weightings.service.converter.StatusConverter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatusService implements CrudService<StatusDto>{
    private final StatusRepository repository;
    private final StatusConverter converter;
    @Override
    public List<StatusDto> findAll() {
        return repository.findAll(Sort.by("status"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StatusDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public StatusDto save(StatusDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public StatusDto save(UUID id, StatusDto dto) {
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
