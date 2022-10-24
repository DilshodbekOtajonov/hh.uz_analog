package com.example.project_blueprint.repository.auth;

import com.example.project_blueprint.domains.auth.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:15 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {

    Optional<OTP> findOTPByCode(String code);
}
