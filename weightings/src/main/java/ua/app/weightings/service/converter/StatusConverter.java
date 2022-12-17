package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.StatusDao;
import ua.app.weightings.model.dto.StatusDto;

@Service
public class StatusConverter implements Convertible<StatusDto, StatusDao> {
    @Override
    public StatusDto toDto(StatusDao dao) {
        StatusDto dto = new StatusDto();
        dto.setId(dao.getId());
        dto.setStatus(dao.getStatus());
        dto.setEvents(dao.getStatusEvents());
        return dto;
    }

    @Override
    public StatusDao toDao(StatusDto dto) {
        return new StatusDao(
                dto.getId(),
                dto.getStatus()
        );
    }
}
