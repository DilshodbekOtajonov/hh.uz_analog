package com.example.resume_service.domains;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 1:17 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String countryName;
}
