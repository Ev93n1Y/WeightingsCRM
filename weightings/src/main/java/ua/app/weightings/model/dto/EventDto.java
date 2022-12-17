package ua.app.weightings.model.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.app.weightings.model.dao.*;

import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class EventDto {
    private UUID id;

    @Size(max = 100)
    private String event;
    private UserDao user;
    private Date date_time;
    private StatusDao status;
    private CompanyDao company;
    private DriverDao driver;
    private TruckDao truck;
    private ProductDao product;
    private ChemicalDao chemical;
    private WeightingDao weighting;
    private DirectionDao direction;
}
