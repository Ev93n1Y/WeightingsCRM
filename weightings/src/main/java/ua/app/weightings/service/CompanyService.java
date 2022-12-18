package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.CompanyDto;
import ua.app.weightings.repository.CompanyRepository;
import ua.app.weightings.service.converter.CompanyConverter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService implements CrudService<CompanyDto>{
    private final CompanyRepository repository;
    private final CompanyConverter converter;
    @Override
    public List<CompanyDto> findAll() {
        return repository.findAll(Sort.by("company"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public CompanyDto save(UUID id, CompanyDto dto) {
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
