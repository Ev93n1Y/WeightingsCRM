package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.DirectionDao;
import ua.app.weightings.model.dto.DirectionDto;

@Service
public class DirectionConverter implements Convertible<DirectionDto, DirectionDao> {
    @Override
    public DirectionDto toDto(DirectionDao dao) {
        DirectionDto dto = new DirectionDto();
        dto.setId(dao.getId());
        dto.setDirection(dao.getDirection());
        dto.setEvents(dao.getDirectionEvents());
        return dto;
    }

    @Override
    public DirectionDao toDao(DirectionDto dto) {
        return new DirectionDao(
                dto.getId(),
                dto.getDirection()
        );
    }
}
