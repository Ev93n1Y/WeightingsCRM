package ua.app.weightings.service.converter;


import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.UserDao;
import ua.app.weightings.model.dto.UserDto;


@Service
public class UserConverter implements Convertible<UserDto, UserDao> {
    @Override
    public UserDto toDto(final UserDao productDao) {
        UserDto userDto = new UserDto();
        userDto.setId(productDao.getId());
        userDto.setName(productDao.getName());
        userDto.setPassword(productDao.getPassword());
        userDto.setLastName(productDao.getLastName());
        userDto.setFirstName(productDao.getFirstName());
        userDto.setRoles(productDao.getRoles());
        //userDto.setRoles(productDao.getRoles().stream()
        //        .map(new RoleConverter()::toDto)
        //        .collect(Collectors.toSet()));
        return userDto;
    }

    @Override
    public UserDao toDao(final UserDto userDto) {
        return new UserDao(
                userDto.getId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getRoles()
                //userDto.getRoles().stream()
                //        .map(new RoleConverter()::toDao)
                //        .collect(Collectors.toSet())
        );
    }
}
