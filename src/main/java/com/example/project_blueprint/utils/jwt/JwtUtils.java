package com.example.project_blueprint.utils.jwt;

import com.example.project_blueprint.service.token.AccessTokenService;
import com.example.project_blueprint.service.token.RefreshTokenService;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:10 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


// TODO: 8/20/22 we wanted it to be factory for token services
public class JwtUtils {
    public static final AccessTokenService accessTokenService = new AccessTokenService();
    public static final RefreshTokenService refreshTokenService = new RefreshTokenService();
}
