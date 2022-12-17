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
@EqualsAndHashCode(of = {"id", "company"})
@ToString(of = {"id", "company"})
@Entity
@Table(name = "companies")
public class CompanyDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "company", length = 100, nullable = false, unique = true)
    private String company;

    @OneToMany(
            mappedBy = "company",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<EventDao> events = new HashSet<>();

    public CompanyDao(UUID id, String company/*, Set<EventDao> events*/) {
        this.id = id;
        this.company = company;
        //this.events = events;
    }

    public Set<EventDao> getCompanyEvents() {
        return Collections.unmodifiableSet(events);
    }

    public void addCompanyEvent(EventDao eventDao) {
        events.add(eventDao);
    }

    public void removeCompanyEvent(EventDao eventDao) {
        events.remove(eventDao);
    }
}
