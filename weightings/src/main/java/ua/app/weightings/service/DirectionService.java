package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.DirectionDto;
import ua.app.weightings.repository.DirectionRepository;
import ua.app.weightings.service.converter.DirectionConverter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectionService implements CrudService<DirectionDto>{
    private final DirectionRepository repository;
    private final DirectionConverter converter;
    @Override
    public List<DirectionDto> findAll() {
        return repository.findAll(Sort.by("direction"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DirectionDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public DirectionDto save(DirectionDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public DirectionDto save(UUID id, DirectionDto dto) {
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
