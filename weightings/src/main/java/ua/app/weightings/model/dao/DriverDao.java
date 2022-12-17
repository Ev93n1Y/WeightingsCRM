package ua.app.weightings.model.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id", "driver", "first_name", "last_name"})
@ToString(of = {"id", "company", "first_name", "last_name"})
@Entity
@Table(name = "drivers")
public class DriverDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "driver", length = 100, nullable = false, unique = true)
    private String driver;

    @Column(name = "first_name", length = 100, nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 100, nullable = false)
    private String last_name;

    @OneToMany(
            mappedBy = "driver",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(name = "event_id")
    /*@JoinTable(
            name = "events",
            joinColumns = {@JoinColumn(name = "driver_id")}
    )*/
    private Set<EventDao> events = new HashSet<>();

    public DriverDao(UUID id, String driver, String first_name, String last_name/*, Set<EventDao> events*/) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        //this.events = events;
    }


    public Set<EventDao> getDriversEvents() {
        return Collections.unmodifiableSet(events);
    }

    public void addDriversEvent(EventDao eventDao) {
        events.add(eventDao);
    }

    public void removeDriversEvent(EventDao eventDao) {
        events.remove(eventDao);
    }
}
