package ua.app.weightings.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.app.weightings.model.dto.EventDto;
import ua.app.weightings.model.dto.ProductDto;
import ua.app.weightings.repository.ProductRepository;
import ua.app.weightings.service.converter.ProductConverter;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements CrudService<ProductDto>{
    private final ProductRepository repository;
    private final ProductConverter converter;
    @Override
    public List<ProductDto> findAll() {
        return repository.findAll(Sort.by("product"))
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(UUID id) {
        return repository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ProductDto save(ProductDto dto) {
        return converter.toDto(repository.save(converter.toDao(dto)));
    }

    @Override
    public ProductDto save(UUID id, ProductDto dto) {
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
