package com.example.project_blueprint.repository.auth;

import com.example.project_blueprint.domains.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {


    @Query("select a from AuthRole a where a.code = ?1")
    AuthRole findByCode(String code);
}
