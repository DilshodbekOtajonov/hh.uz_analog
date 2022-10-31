package com.example.project_blueprint.service.specialization;

import com.example.project_blueprint.domains.specialization.Category;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 25/10/22 23:13 (Tuesday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
public interface CategoryService {
    Category getCategoryById(Long id);
}
