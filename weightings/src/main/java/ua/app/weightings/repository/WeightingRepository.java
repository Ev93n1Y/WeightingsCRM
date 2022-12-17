package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.WeightingDao;

import java.util.UUID;

public interface WeightingRepository extends JpaRepository<WeightingDao, UUID> {
}
