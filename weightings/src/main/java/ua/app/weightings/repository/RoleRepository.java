package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.RoleDao;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleDao, UUID> {
    RoleDao findByRole(String role);
}
