package com.example.project_blueprint.domains.address;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 21:11 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Country extends Auditable {

    private String name;
    @Builder(builderMethodName = "childBuilder")
    public Country(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String name) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.name = name;
    }
}
