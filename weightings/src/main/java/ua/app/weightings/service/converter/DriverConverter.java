package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.DriverDao;
import ua.app.weightings.model.dto.DriverDto;

@Service
public class DriverConverter implements Convertible<DriverDto, DriverDao> {
    @Override
    public DriverDto toDto(DriverDao dao) {
        DriverDto dto = new DriverDto();
        dto.setId(dao.getId());
        dto.setFirst_name(dao.getFirst_name());
        dto.setLast_name(dao.getLast_name());
        dto.setEvents(dao.getDriversEvents());
        return dto;
    }

    @Override
    public DriverDao toDao(DriverDto dto) {
        return new DriverDao(
                dto.getId(),
                dto.getFirst_name(),
                dto.getLast_name()
        );
    }
}
