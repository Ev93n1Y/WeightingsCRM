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
@EqualsAndHashCode(of = {"id", "status"})
@ToString(of = {"id", "status"})
@Entity
@Table(name = "statuses")
public class StatusDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "status", length = 100, nullable = false, unique = true)
    private String status;

    @OneToMany(
            mappedBy = "status",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(name = "event_id")
    /*@JoinTable(
            name = "events",
            joinColumns = {@JoinColumn(name = "status_id")}
    )*/
    private Set<EventDao> events = new HashSet<>();

    public StatusDao(UUID id, String status/*, Set<EventDao> events*/) {
        this.id = id;
        this.status = status;
        //this.events = events;
    }

    public Set<EventDao> getStatusEvents() {
        return Collections.unmodifiableSet(events);
    }

    public void addStatusEvent(EventDao eventDao) {
        events.add(eventDao);
    }

    public void removeStatusEvent(EventDao eventDao) {
        events.remove(eventDao);
    }
}
