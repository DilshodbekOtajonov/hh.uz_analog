package com.example.project_blueprint.domains.address;

import com.example.project_blueprint.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 21/10/22 18:19 (Friday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class City extends Auditable {

    private Long countryId;
    private String cityName;
    @Builder(builderMethodName = "childBuilder")
    public City(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, Long countryId, String cityName) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.countryId = countryId;
        this.cityName = cityName;
    }
}
