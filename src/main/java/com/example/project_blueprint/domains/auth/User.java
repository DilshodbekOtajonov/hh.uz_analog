package com.example.project_blueprint.domains.auth;

import com.example.project_blueprint.enums.auth.UserStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:03 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    public User() {
        this.fullName = firstName+" "+lastName;
    }

    private String fullName;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<AuthRole> roles = new HashSet<>();

    private String phoneNumber;
    private String jobSearchArea;
    private String socialMedia;
}
