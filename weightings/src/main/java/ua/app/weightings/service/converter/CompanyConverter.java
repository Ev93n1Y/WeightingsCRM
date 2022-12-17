package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.CompanyDao;
import ua.app.weightings.model.dto.CompanyDto;

@Service
public class CompanyConverter implements Convertible<CompanyDto, CompanyDao> {
    @Override
    public CompanyDto toDto(CompanyDao dao) {
        CompanyDto dto = new CompanyDto();
        dto.setId(dao.getId());
        dto.setCompany(dao.getCompany());
        dto.setEvents(dao.getCompanyEvents());
        return dto;
    }

    @Override
    public CompanyDao toDao(CompanyDto dto) {
        return new CompanyDao(
                dto.getId(),
                dto.getCompany()
        );
    }
}
