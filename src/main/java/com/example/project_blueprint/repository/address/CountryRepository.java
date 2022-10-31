package com.example.project_blueprint.repository.address;

import com.example.project_blueprint.domains.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:30 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
public interface CountryRepository extends JpaRepository<Country,Long> {
}
