package com.example.project_blueprint.dto.employer.auth;

import com.example.project_blueprint.domains.auth.Employer;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = Employer.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "employer_id")
    private Employer employer;

    private Date expiryDate;
}
