package com.example.resume_service.domains;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 7:14 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//@Table(schema = "resume_schema")
public class ExperienceEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToMany
   private List<WorkPlacesEntity> workPlaces;

   private String institution;

   private String faculty;

   private String specialization;

   private Integer yearOfEnding;
}
