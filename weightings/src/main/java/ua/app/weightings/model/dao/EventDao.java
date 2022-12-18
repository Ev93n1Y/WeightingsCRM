package ua.app.weightings.model.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id", "user", "date_time", "status", "company",
        "driver", "truck", "chemical", "weighting", "direction"})
@ToString(of = {"id", "user", "date_time", "status", "company",
        "driver", "truck", "chemical", "weighting", "direction"})
@Entity
@Table(name = "events")
public class EventDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserDao user;

    @Column(name = "date_time")
    private Timestamp date_time;

    @ManyToOne()
    @JoinColumn(name = "status_id")
    private StatusDao status;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private CompanyDao company;

    @ManyToOne()
    @JoinColumn(name = "driver_id")
    private DriverDao driver;

    @ManyToOne()
    @JoinColumn(name = "truck_id")
    private TruckDao truck;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductDao product;

    @ManyToOne()
    @JoinColumn(name = "chemical_id")
    private ChemicalDao chemical;

    @ManyToOne()
    @JoinColumn(name = "weighting_id")
    private WeightingDao weighting;

    @ManyToOne()
    @JoinColumn(name = "direction_id")
    private DirectionDao direction;

    public EventDao(UUID id, UserDao user, Timestamp date_time, StatusDao status, CompanyDao company,
                    DriverDao driver, ProductDao product, TruckDao truck, ChemicalDao chemical,
                    WeightingDao weighting, DirectionDao direction) {
        this.id = id;
        this.user = user;
        this.date_time = date_time;
        this.status = status;
        this.company = company;
        this.driver = driver;
        this.product = product;
        this.truck = truck;
        this.chemical = chemical;
        this.weighting = weighting;
        this.direction = direction;
    }
}
