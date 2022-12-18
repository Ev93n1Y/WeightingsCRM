package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.EventDto;
import ua.app.weightings.repository.EventRepository;
import ua.app.weightings.service.converter.EventConverter;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService implements CrudService<EventDto>{
    private final EventRepository repository;
    private final EventConverter converter;
    @Override
    public List<EventDto> findAll() {
        return repository.findAll(Sort.by("id"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public EventDto save(EventDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public EventDto save(UUID id, EventDto dto) {
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
