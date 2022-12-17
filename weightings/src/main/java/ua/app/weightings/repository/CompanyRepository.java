package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.CompanyDao;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyDao, UUID> {
}
