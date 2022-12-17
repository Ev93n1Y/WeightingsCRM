package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.TruckDao;

import java.util.UUID;

public interface TruckRepository extends JpaRepository<TruckDao, UUID> {
}
