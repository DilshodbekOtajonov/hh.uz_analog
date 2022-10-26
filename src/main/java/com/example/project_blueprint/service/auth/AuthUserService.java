package com.example.project_blueprint.service.auth;

import com.example.project_blueprint.domains.auth.AuthUser;
import com.example.project_blueprint.dto.VerifyTokenRequestDTO;
import com.example.project_blueprint.dto.employer.auth.VerifyForEmpTokenRequestDTO;
import com.example.project_blueprint.exceptions.UserNotActiveException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class AuthUserService {
    private static final Integer EXPIRE_MIN = 5;
    private LoadingCache<String, Boolean> authUserCache;

    public AuthUserService() {
        super();
        authUserCache = CacheBuilder.newBuilder()
                .expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Boolean>() {
                    @Override
                    public Boolean load(String s) throws Exception {
                        return false;
                    }
                });
    }

    public AuthUser create(VerifyTokenRequestDTO dto) {
        AuthUser key = AuthUser.builder()
                .email(dto.getEmail())
                .isActive(true)
                .build();
        authUserCache.put(key.getEmail(), key.getIsActive());
        return key;
    }

    public AuthUser createForEmp(VerifyForEmpTokenRequestDTO dto) {
        AuthUser key = AuthUser.builder()
                .email(dto.getEmail())
                .isActive(true)
                .build();
        authUserCache.put(key.getEmail(), key.getIsActive());
        return key;
    }

    public AuthUser getAuthUserByEmail(String email) {
        if (!authUserCache.getIfPresent(email)) {
            new UserNotActiveException("user not active by email %s".formatted(email));
        }
        return AuthUser.builder()
                .email(email)
                .isActive(true)
                .build();
    }

    public void clearAuthUserFromCache(String email) {
        authUserCache.invalidate(email);
    }

    public Boolean validateAuthUser(AuthUser key) {
        // get AuthUser from cache
        Boolean cacheAuthUser = getAuthUserByEmail(key.getEmail()).getIsActive();
        if (cacheAuthUser != null && cacheAuthUser.equals(true)) {
            clearAuthUserFromCache(key.getEmail());
            return true;
        }
        return false;
    }
}
