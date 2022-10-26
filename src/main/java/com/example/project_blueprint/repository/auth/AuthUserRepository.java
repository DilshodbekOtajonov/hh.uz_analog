package com.example.project_blueprint.repository.auth;

import com.example.project_blueprint.domains.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, GenericRepo{
    @Query(value = " select  * from auth_users us   where us.email =:email", nativeQuery = true)
    Optional<AuthUser> findByEmail(String email);
}
