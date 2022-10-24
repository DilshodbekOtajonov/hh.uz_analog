package com.example.resume_service.domains;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:41 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String skillName;
}
