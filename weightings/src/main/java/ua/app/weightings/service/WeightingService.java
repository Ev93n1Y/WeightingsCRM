package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.WeightingDto;
import ua.app.weightings.repository.WeightingRepository;
import ua.app.weightings.service.converter.WeightingConverter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeightingService implements CrudService<WeightingDto>{
    private final WeightingRepository repository;
    private final WeightingConverter converter;
    @Override
    public List<WeightingDto> findAll() {
        return repository.findAll(Sort.by("id"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WeightingDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public WeightingDto save(WeightingDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public WeightingDto save(UUID id, WeightingDto dto) {
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
