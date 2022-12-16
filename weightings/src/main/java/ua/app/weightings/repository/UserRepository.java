package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.UserDao;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDao, UUID> {
    UserDao findByName(String name);
}
