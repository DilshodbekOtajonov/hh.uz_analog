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
public class AccessTokenService extends AbstractTokenService implements TokenService {

    @Value("${jwt.access.token.secret}")
    private String accessTokenSecret="U0RGVyQ0MzUzZnNkRyUkXiQlXjxERkhHPE9ZVUslJF4+SkhGR0pUUllVJV4=";

    @Value("${jwt.access.token.expiry.adding.amount}")
    private Integer amountToAdd = 10;

    @Value("${jwt.access.token.expiry.time.unit}")
    private TemporalUnit unit= ChronoUnit.MINUTES;


    @Override
    public String generateToken(String email) {
        return jwt(email);
    }


    @Override
    public Boolean isValid(String token) {
        return super.isTokenValid(token, this.accessTokenSecret);
    }


    public String getSubject(String token) {
        return super.getSubject(token, accessTokenSecret);
    }


    public String jwt(@NonNull String subject) {
        return super.jwt(subject, this.accessTokenSecret, this.amountToAdd, this.unit);
    }

    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(accessTokenSecret.getBytes());
    }


    public JWTVerifier getVerifier(){
        return JWT.require(getAlgorithm()).build();
    }
}
