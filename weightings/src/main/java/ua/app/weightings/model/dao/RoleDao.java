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
@EqualsAndHashCode(of = {"id", "role"})
@ToString(of = {"id", "role"})
@Entity
@Table(name = "roles")
public class RoleDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "role", length = 100, nullable = false, unique = true)
    private String role;

    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserDao> users = new HashSet<>();

    public RoleDao(UUID id, String role/*, Set<UserDao> users*/) {
        this.id = id;
        this.role = role;
        //this.users = users;
    }

    public Set<UserDao> getRoleUsers() {
        return Collections.unmodifiableSet(users);
    }

    public void addRoleUser(UserDao userDao) {
        users.add(userDao);
    }

    public void removeRoleUser(UserDao userDao) {
        users.remove(userDao);
    }
}
