package com.example.project_blueprint.domains.address;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 21/10/22 18:18 (Friday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address extends Auditable {

    @Builder(builderMethodName = "childBuilder")
    public Address(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
    }
}
