package com.example.project_blueprint.service.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.project_blueprint.domains.auth.CustomUserDetails;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:13 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public class RefreshTokenService extends AbstractTokenService implements TokenService {

    @Value("${jwt.refresh.token.secret}")
    private String refreshTokenSecret="c2RGJF4lJiVeKERGR05NU0RGR0xFRktHREZMT0pUIylUIyQlXiMkJV9eJCVe";

    @Value("${jwt.refresh.token.expiry.adding.amount}")
    private Integer amountToAdd=10;

    @Value("${jwt.refresh.token.expiry.time.unit}")
    private TemporalUnit unit= ChronoUnit.DAYS;


    @Override
    public String generateToken(String email) {
        return jwt(email);
    }

    @Override
    public Boolean isValid(String token) {
        return super.isTokenValid(token, refreshTokenSecret);
    }


    public String getSubject(String token) {
        return super.getSubject(token, refreshTokenSecret);
    }



    public String jwt(@NonNull String subject) {
        return super.jwt(subject, this.refreshTokenSecret, this.amountToAdd, this.unit);
    }

    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(refreshTokenSecret.getBytes());
    }


    public JWTVerifier getVerifier(){
        return JWT.require(getAlgorithm()).build();
    }
}
