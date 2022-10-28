package com.example.project_blueprint.domains.auth;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String name;

    private String password;

    @Column(nullable = false)
    private String surName;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String region;

    @Column(name = "reset_token")
    private String resetToken;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployerStatus status = EmployerStatus.IN_ACTIVE;

    public enum EmployerStatus {
        ACTIVE, IN_ACTIVE;

        public static EmployerStatus getByName(String employerStatusName) {
            for (EmployerStatus employerStatus : values()) {
                if (employerStatus.name().equalsIgnoreCase(employerStatusName))
                    return employerStatus;
            }
            return IN_ACTIVE;
        }
    }
}
