package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.ChemicalDao;

import java.util.UUID;

public interface ChemicalRepository extends JpaRepository<ChemicalDao, UUID> {
}
