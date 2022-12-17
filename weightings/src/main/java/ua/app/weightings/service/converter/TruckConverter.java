package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.TruckDao;
import ua.app.weightings.model.dto.TruckDto;

@Service
public class TruckConverter implements Convertible<TruckDto, TruckDao> {
    @Override
    public TruckDto toDto(TruckDao dao) {
        TruckDto dto = new TruckDto();
        dto.setId(dao.getId());
        dto.setTruck(dao.getTruck());
        dto.setEvents(dao.getTruckEvents());
        return dto;
    }

    @Override
    public TruckDao toDao(TruckDto dto) {
        return new TruckDao(
                dto.getId(),
                dto.getTruck()
        );
    }
}
