package com.example.project_blueprint.domains.specialization;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 14:22 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specialization extends Auditable {
    private String name;
    private Long categoryId;

    @Builder(builderMethodName = "childBuilder")
    public Specialization(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String name, Long categoryId) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.name = name;
        this.categoryId = categoryId;
    }
}
