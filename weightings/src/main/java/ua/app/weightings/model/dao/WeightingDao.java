package ua.app.weightings.model.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.UUID;


@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id", "brutto_time", "brutto", "tara_time", "tara", "netto"})
@ToString(of = {"id", "brutto_time", "brutto", "tara_time", "tara", "netto"})
@Entity
@Table(name = "weightings")
public class WeightingDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "brutto_time")
    private Date brutto_time;

    @Column(name = "brutto")
    private Integer brutto;

    @Column(name = "tara_time")
    private Date tara_time;

    @Column(name = "tara")
    private Integer tara;

    @Column(name = "netto")
    private Integer netto;

    @Setter
    @OneToOne(
            mappedBy = "weighting",
            cascade = CascadeType.ALL, orphanRemoval = true
    )
    private EventDao event;

    public WeightingDao(UUID id, Date brutto_time, Integer brutto, Date tara_time, Integer tara, Integer netto, EventDao event) {
        this.id = id;
        this.brutto_time = brutto_time;
        this.brutto = brutto;
        this.tara_time = tara_time;
        this.tara = tara;
        this.netto = netto;
        this.event = event;
    }
}
