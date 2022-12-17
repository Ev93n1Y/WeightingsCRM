package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.EventDao;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventDao, UUID> {
}
