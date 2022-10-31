package com.example.project_blueprint.domains.specialization;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 25/10/22 23:02 (Tuesday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends Auditable {
    private String name;
    @Builder(builderMethodName = "childBuilder")
    public Category(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String name) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.name = name;
    }
}
