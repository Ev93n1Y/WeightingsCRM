package ua.app.weightings.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.app.weightings.model.dao.*;

import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class WeightingDto {
    private UUID id;
    private Date brutto_time;
    private Integer brutto;
    private Date tara_time;
    private Integer tara;
    private Integer netto;
    private EventDao event;
}
