package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.DirectionDao;

import java.util.UUID;

public interface DirectionRepository extends JpaRepository<DirectionDao, UUID> {
}
