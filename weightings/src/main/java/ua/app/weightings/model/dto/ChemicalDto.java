package ua.app.weightings.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.app.weightings.model.dao.ProductDao;

import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class ChemicalDto {
    private UUID id;

    private Integer humidity;

    private ProductDao product;
}
