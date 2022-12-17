package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.ChemicalDao;
import ua.app.weightings.model.dto.ChemicalDto;

@Service
public class ChemicalConverter implements Convertible<ChemicalDto, ChemicalDao> {
    @Override
    public ChemicalDto toDto(ChemicalDao dao) {
        ChemicalDto dto = new ChemicalDto();
        dto.setId(dao.getId());
        dto.setHumidity(dao.getHumidity());
        dto.setProduct(dao.getProduct());
        return dto;
    }

    @Override
    public ChemicalDao toDao(ChemicalDto dto) {
        return new ChemicalDao(
                dto.getId(),
                dto.getHumidity(),
                dto.getProduct()
        );
    }
}
