package com.example.project_blueprint.service.token;

import com.example.project_blueprint.domains.auth.CustomUserDetails;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:11 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public interface TokenService {

    String generateToken(String email);

    Boolean isValid(String token);


}
