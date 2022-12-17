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
@Getter
@EqualsAndHashCode(of = {"id", "direction"})
@ToString(of = {"id", "direction"})
@Entity
@Table(name = "directions")
public class DirectionDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "direction", length = 100, nullable = false, unique = true)
    private String direction;

    @OneToMany(
            mappedBy = "direction",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(name = "event_id")
    /*@JoinTable(
            name = "events",
            joinColumns = {@JoinColumn(name = "direction_id")}
    )*/
    private Set<EventDao> events = new HashSet<>();

    public DirectionDao(UUID id, String direction/*, Set<EventDao> events*/) {
        this.id = id;
        this.direction = direction;
        //this.events = events;
    }

    public Set<EventDao> getDirectionEvents() {
        return Collections.unmodifiableSet(events);
    }

    public void addDirectionEvent(EventDao eventDao) {
        events.add(eventDao);
    }

    public void removeDirectionEvent(EventDao eventDao) {
        events.remove(eventDao);
    }
}
