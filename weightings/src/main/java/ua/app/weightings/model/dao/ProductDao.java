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
@EqualsAndHashCode(of = {"id", "product"})
@ToString(of = {"id", "product"})
@Entity
@Table(name = "products")
public class ProductDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "product", length = 100, nullable = false, unique = true)
    private String product;

    @OneToMany(
            mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<EventDao> events = new HashSet<>();

    public ProductDao(UUID id, String product/*, Set<EventDao> events*/) {
        this.id = id;
        this.product = product;
        //this.events = events;
    }

    public Set<EventDao> getProductEvents() {
        return Collections.unmodifiableSet(events);
    }

    public void addProductEvent(EventDao eventDao) {
        events.add(eventDao);
    }

    public void removeProductEvent(EventDao eventDao) {
        events.remove(eventDao);
    }
}
