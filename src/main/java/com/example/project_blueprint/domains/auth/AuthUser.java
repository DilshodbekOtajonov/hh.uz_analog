package com.example.project_blueprint.domains.auth;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:04 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserInfo userInfo;
}
