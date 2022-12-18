package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.EventDao;
import ua.app.weightings.model.dto.EventDto;

@Service
public class EventConverter implements Convertible<EventDto, EventDao> {
    @Override
    public EventDto toDto(EventDao dao) {
        EventDto dto = new EventDto();
        dto.setId(dao.getId());
        dto.setUser(dao.getUser());
        dto.setDate_time(dao.getDate_time());
        dto.setStatus(dao.getStatus());
        dto.setCompany(dao.getCompany());
        dto.setDriver(dao.getDriver());
        dto.setTruck(dao.getTruck());
        dto.setProduct(dao.getProduct());
        dto.setChemical(dao.getChemical());
        dto.setWeighting(dao.getWeighting());
        dto.setDirection(dao.getDirection());
        return dto;
    }

    @Override
    public EventDao toDao(EventDto dto) {
        return new EventDao(
                dto.getId(),
                dto.getUser(),
                dto.getDate_time(),
                dto.getStatus(),
                dto.getCompany(),
                dto.getDriver(),
                dto.getProduct(),
                dto.getTruck(),
                dto.getChemical(),
                dto.getWeighting(),
                dto.getDirection()
        );
    }
}
