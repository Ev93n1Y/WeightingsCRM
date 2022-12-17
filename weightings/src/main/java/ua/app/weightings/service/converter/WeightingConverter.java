package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.WeightingDao;
import ua.app.weightings.model.dto.WeightingDto;

@Service
public class WeightingConverter implements Convertible<WeightingDto, WeightingDao> {
    @Override
    public WeightingDto toDto(WeightingDao dao) {
        WeightingDto dto = new WeightingDto();
        dto.setId(dao.getId());
        dto.setBrutto_time(dao.getBrutto_time());
        dto.setBrutto(dao.getBrutto());
        dto.setTara_time(dao.getTara_time());
        dto.setTara(dao.getTara());
        dto.setNetto(dao.getNetto());
        dto.setEvent(dao.getEvent());
        return dto;
    }

    @Override
    public WeightingDao toDao(WeightingDto dto) {
        return new WeightingDao(
                dto.getId(),
                dto.getBrutto_time(),
                dto.getBrutto(),
                dto.getTara_time(),
                dto.getTara(),
                dto.getNetto(),
                dto.getEvent()
        );
    }
}
