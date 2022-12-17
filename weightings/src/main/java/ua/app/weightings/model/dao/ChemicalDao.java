package ua.app.weightings.model.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id", "driver", "first_name"})
@ToString(of = {"id", "company", "first_name"})
@Entity
@Table(name = "chemicals")
public class ChemicalDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "humidity", nullable = false)
    private Integer humidity;


    //???? do we need product here?
    @Setter
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductDao product;

    public ChemicalDao(UUID id, Integer humidity, ProductDao product) {
        this.id = id;
        this.humidity = humidity;
        this.product = product;
    }
}
