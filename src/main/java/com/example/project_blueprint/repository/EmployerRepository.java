package com.example.project_blueprint.repository;

import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.repository.auth.GenericRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long>, GenericRepo {
    @Query(value = " select  * from employers us   where us.email =:email", nativeQuery = true)
    Optional<Employer> findByEmail(String email);

    @Query(value = " select  * from employers us   where us.email =:email and us.password =:password", nativeQuery = true)
    Optional<Employer> findByEmailAndPassword(String email, String password);

    Optional<Employer> findByResetToken(String resetToken);
}
