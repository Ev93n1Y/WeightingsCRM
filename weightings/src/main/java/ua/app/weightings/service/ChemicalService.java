package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.ChemicalDto;
import ua.app.weightings.repository.ChemicalRepository;
import ua.app.weightings.service.converter.ChemicalConverter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChemicalService implements CrudService<ChemicalDto>{
    private final ChemicalRepository repository;
    private final ChemicalConverter converter;
    @Override
    public List<ChemicalDto> findAll() {
        return repository.findAll(Sort.by("id"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ChemicalDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ChemicalDto save(ChemicalDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public ChemicalDto save(UUID id, ChemicalDto dto) {
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
