package ua.app.weightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.app.weightings.model.dao.ProductDao;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductDao, UUID> {
}
