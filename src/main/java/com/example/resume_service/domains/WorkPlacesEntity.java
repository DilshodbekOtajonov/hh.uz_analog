package com.example.resume_service.domains;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 6:57 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class WorkPlacesEntity extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startWork;
    @Column(columnDefinition = "bool default false")
    private Boolean isEndWork;
    private LocalDate endWork;
    private String organization;
    private String position;
    private String jobDuties;

    @Builder(builderClassName = "childBuilder")
    public WorkPlacesEntity(Timestamp createdAt, Timestamp updatedAt, Long createdBy, Long updatedBy, boolean deleted, Long id, LocalDate startWork, Boolean isEndWork, LocalDate endWork, String organization, String position, String jobDuties) {
        super ( createdAt, updatedAt, createdBy, updatedBy, deleted );
        this.id = id;
        this.startWork = startWork;
        this.isEndWork = isEndWork;
        this.endWork = endWork;
        this.organization = organization;
        this.position = position;
        this.jobDuties = jobDuties;
    }
}
