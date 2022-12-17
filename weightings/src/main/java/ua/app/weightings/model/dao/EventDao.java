package ua.app.weightings.model.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id", "user", "date_time", "status", "company_id",
        "driver_id", "truck_id", "chemical_id", "weighting_id", "direction_id"})
@ToString(of = {"id", "user", "date_time", "status", "company_id",
        "driver_id", "truck_id", "chemical_id", "weighting_id", "direction_id"})
@Entity
@Table(name = "events")
public class EventDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "event", length = 100, nullable = false)
    private String event;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserDao user;

    @Column(name = "date_time")
    private Date date_time;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "status_id")
    private StatusDao status;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "company_id")
    private CompanyDao company;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "driver_id")
    private DriverDao driver;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "truck_id")
    private TruckDao truck;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductDao product;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "chemical_id")
    private ChemicalDao chemical;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "weighting_id")
    private WeightingDao weighting;

    @Setter
    @ManyToOne()
    @JoinColumn(name = "direction_id")
    private DirectionDao direction;

    public EventDao(UUID id, String event, UserDao user, Date date_time, StatusDao status, CompanyDao company,
                    DriverDao driver, ProductDao product, TruckDao truck, ChemicalDao chemical,
                    WeightingDao weighting, DirectionDao direction) {
        this.id = id;
        this.event = event;
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
