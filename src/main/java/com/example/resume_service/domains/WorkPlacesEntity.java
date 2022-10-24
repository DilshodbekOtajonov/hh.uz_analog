package com.example.resume_service.domains;

import lombok.*;

import javax.persistence.*;
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
@Builder
public class WorkPlacesEntity {
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

}
