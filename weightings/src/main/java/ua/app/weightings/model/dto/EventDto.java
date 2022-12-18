package ua.app.weightings.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.app.weightings.model.dao.*;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class EventDto {
    private UUID id;
    private UserDao user;
    private Timestamp date_time;
    private StatusDao status;
    private CompanyDao company;
    private DriverDao driver;
    private TruckDao truck;
    private ProductDao product;
    private ChemicalDao chemical;
    private WeightingDao weighting;
    private DirectionDao direction;
}
