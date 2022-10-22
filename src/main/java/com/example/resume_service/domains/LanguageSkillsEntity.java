package com.example.resume_service.domains;

import com.example.resume_service.enums.LanguageLevel;
import lombok.*;

import javax.persistence.*;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 7:37 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
//@Table(schema = "resume_schema")
public class LanguageSkillsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  language;

    @Enumerated(value = EnumType.STRING)
    private LanguageLevel level;
}
