package ua.app.weightings.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.app.weightings.model.dao.RoleDao;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class UserDto {
    private UUID id;

    @Email()
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String password;

    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    private Set<RoleDao> roles;
}
