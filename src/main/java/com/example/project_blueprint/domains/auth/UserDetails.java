package com.example.project_blueprint.domains.auth;

import com.example.project_blueprint.enums.auth.UserStatus;
import lombok.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class UserDetails {
    @Column(nullable = false)
    private String fullName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<AuthRole> roles = new HashSet<>();

    @Builder.Default
    private Boolean isActive = true;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String jobSearchArea;
    @Column(nullable = false)
    private String socialMedia;

}
