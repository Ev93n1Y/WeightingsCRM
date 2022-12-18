package ua.app.weightings.model.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "first_name", "last_name"})
@ToString(of = {"id", "first_name", "last_name"})
@Entity
@Table(name = "drivers")
public class DriverDao {
    @Getter
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Getter
    @Column(name = "first_name", length = 100, nullable = false)
    private String first_name;

    @Getter
    @Column(name = "last_name", length = 100, nullable = false)
    private String last_name;

    @OneToMany(
            mappedBy = "driver",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<EventDao> events = new HashSet<>();

    public DriverDao(UUID id, String first_name, String last_name/*, Set<EventDao> events*/) {
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
