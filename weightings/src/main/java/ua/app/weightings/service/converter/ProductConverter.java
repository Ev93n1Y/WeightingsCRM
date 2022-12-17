package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.ProductDao;
import ua.app.weightings.model.dto.ProductDto;

@Service
public class ProductConverter implements Convertible<ProductDto, ProductDao> {
    @Override
    public ProductDto toDto(ProductDao dao) {
        ProductDto dto = new ProductDto();
        dto.setId(dao.getId());
        dto.setProduct(dao.getProduct());
        dto.setEvents(dao.getProductEvents());
        return dto;
    }

    @Override
    public ProductDao toDao(ProductDto dto) {
        return new ProductDao(
                dto.getId(),
                dto.getProduct()
        );
    }
}
