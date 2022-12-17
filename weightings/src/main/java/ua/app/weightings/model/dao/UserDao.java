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
@EqualsAndHashCode(of = {"id", "name", "firstName", "lastName"})
@ToString(of = {"id", "name", "firstName", "lastName"})
@Entity
@Table(name = "users")
public class UserDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleDao> roles = new HashSet<>();

    public UserDao(UUID id, String name, String password, String firstName, String lastName/*, Set<RoleDao> roles*/) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.roles = roles;
    }

    public Set<RoleDao> getUserRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public void addUserRole(RoleDao roleDao) {
        roles.add(roleDao);
    }

    public void removeUserRole(RoleDao roleDao) {
        roles.remove(roleDao);
    }
}
