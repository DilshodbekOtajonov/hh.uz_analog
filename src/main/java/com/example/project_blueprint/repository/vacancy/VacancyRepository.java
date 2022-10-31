package com.example.project_blueprint.repository.vacancy;

import com.example.project_blueprint.domains.vacancy.Vacancy;
import org.apache.el.lang.ELArithmetic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 16:47 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
public interface VacancyRepository extends JpaRepository<Vacancy,Long> {
      Optional<Vacancy> findById(Long id);
}
