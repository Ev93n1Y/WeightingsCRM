package ua.app.weightings.service.converter;

import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.RoleDao;
import ua.app.weightings.model.dto.RoleDto;

@Service
public class RoleConverter implements Convertible<RoleDto, RoleDao> {
    @Override
    public RoleDto toDto(RoleDao roleDao) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(roleDao.getId());
        roleDto.setRole(roleDao.getRole());
        roleDto.setUsers(roleDto.getUsers());
        //roleDto.setUsers(roleDao.getUsers().stream().map(new UserConverter()::toDto).collect(Collectors.toSet()));
        return roleDto;
    }

    @Override
    public RoleDao toDao(RoleDto roleDto) {
        return new RoleDao(
                roleDto.getId(),
                roleDto.getRole()
                //roleDto.getUsers()
                //roleDto.getUsers().stream().map(new UserConverter()::toDao).collect(Collectors.toSet())
        );
    }
}
