package ua.app.weightings.model.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.app.weightings.model.dao.EventDao;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class ProductDto {
    private UUID id;

    @Size(max = 100)
    private String product;

    private Set<EventDao> events;
}
