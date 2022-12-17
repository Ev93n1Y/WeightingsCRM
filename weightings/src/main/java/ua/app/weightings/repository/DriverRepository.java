package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.DriverDao;

import java.util.UUID;

public interface DriverRepository extends JpaRepository<DriverDao, UUID> {
}
