package com.example.project_blueprint.domains.vacancy;

import com.example.project_blueprint.domains.Auditable;
import com.example.project_blueprint.enums.vacancy.PublicationType;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 5:00 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publication extends Auditable {

    private PublicationType publicationType;
    private LocalDateTime publicationTime;

    @Builder(builderMethodName = "childBuilder")
    public Publication(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, PublicationType publicationType, LocalDateTime publicationTime) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.publicationType = publicationType;
        this.publicationTime = publicationTime;
    }
}
