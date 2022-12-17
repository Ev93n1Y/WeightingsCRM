package ua.app.weightings.model.dao;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "truck"})
@ToString(of = {"id", "truck"})
@Entity
@Table(name = "trucks")
public class TruckDao {
    @Getter
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Getter
    @Column(name = "truck", length = 100, nullable = false, unique = true)
    private String truck;

    @OneToMany(
            mappedBy = "truck",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<EventDao> events = new HashSet<>();

    public TruckDao(UUID id, String truck/*, Set<EventDao> events*/) {
        this.id = id;
        this.truck = truck;
        //this.events = events;
    }

    public Set<EventDao> getTruckEvents() {
        return Collections.unmodifiableSet(events);
    }

    public void addTruckEvent(EventDao eventDao) {
        events.add(eventDao);
    }

    public void removeTruckEvent(EventDao eventDao) {
        events.remove(eventDao);
    }
}
