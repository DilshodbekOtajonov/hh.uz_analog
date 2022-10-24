package com.example.project_blueprint.domains.auth;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:13 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class OTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Builder.Default
    private Boolean isUsed = false;
    private LocalDateTime validTill;

    @Column(nullable = false)
    private String email;
}
