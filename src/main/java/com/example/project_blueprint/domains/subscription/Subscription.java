package com.example.project_blueprint.domains.subscription;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 23:56 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscription extends Auditable {

    private String title;


    @Builder(builderMethodName = "childBuilder")
    public Subscription(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
    }
}
