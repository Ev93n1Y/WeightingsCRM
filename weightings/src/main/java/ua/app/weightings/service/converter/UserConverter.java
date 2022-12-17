package ua.app.weightings.service.converter;


import org.springframework.stereotype.Service;
import ua.app.weightings.model.dao.UserDao;
import ua.app.weightings.model.dto.UserDto;


@Service
public class UserConverter implements Convertible<UserDto, UserDao> {
    @Override
    public UserDto toDto(UserDao productDao) {
        UserDto userDto = new UserDto();
        userDto.setId(productDao.getId());
        userDto.setName(productDao.getName());
        userDto.setPassword(productDao.getPassword());
        userDto.setLastName(productDao.getLastName());
        userDto.setFirstName(productDao.getFirstName());
        userDto.setRoles(productDao.getUserRoles());
        return userDto;
    }

    @Override
    public UserDao toDao(UserDto userDto) {
        return new UserDao(
                userDto.getId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName()
        );
    }
}
