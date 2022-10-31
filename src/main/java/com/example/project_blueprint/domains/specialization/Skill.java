package com.example.project_blueprint.domains.specialization;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 17:56 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skill extends Auditable {

    private String name;
    @Builder(builderMethodName = "childBuilder")
    public Skill(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
    }
}
