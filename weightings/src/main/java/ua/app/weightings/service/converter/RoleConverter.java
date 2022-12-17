package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.RoleDao;
import ua.app.weightings.model.dto.RoleDto;

@Service
public class RoleConverter implements Convertible<RoleDto, RoleDao> {
    @Override
    public RoleDto toDto(RoleDao dao) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(dao.getId());
        roleDto.setRole(dao.getRole());
        roleDto.setUsers(dao.getRoleUsers());
        return roleDto;
    }

    @Override
    public RoleDao toDao(RoleDto dto) {
        return new RoleDao(
                dto.getId(),
                dto.getRole()
        );
    }
}
