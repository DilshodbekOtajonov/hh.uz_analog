package com.example.project_blueprint.domains.language;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 25/10/22 18:16 (Tuesday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Language extends Auditable {
    private String name;
    private String code;

    @Builder(builderMethodName = "childBuilder")
    public Language(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String name, String code) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.name = name;
        this.code = code;
    }
}
