package com.example.project_blueprint.service.specialization;

import com.example.project_blueprint.domains.specialization.Category;
import com.example.project_blueprint.exceptions.CategoryNotFoundException;
import com.example.project_blueprint.repository.specialization.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 25/10/22 23:14 (Tuesday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public Category getCategoryById(Long id) {
        Category categoryNotFoundById = categoryRepository.findById(id).orElseThrow(() -> {
            throw new CategoryNotFoundException("Category Not Found By Id");
        });
        return categoryNotFoundById;
    }
}
