package com.example.project_blueprint.repository.auth;

import com.example.project_blueprint.domains.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
    AuthRole findByCode(String code);
}
