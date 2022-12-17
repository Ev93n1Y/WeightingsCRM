package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.StatusDao;

import java.util.UUID;

public interface StatusRepository extends JpaRepository<StatusDao, UUID> {
}
