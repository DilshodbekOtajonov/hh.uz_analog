package com.example.project_blueprint.repository.auth;

import com.example.project_blueprint.domains.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:28 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>, GenericRepo{

    @Query(value = " select  * from users us   where us.email =:email", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
