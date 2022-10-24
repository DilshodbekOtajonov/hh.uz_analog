package com.example.resume_service.domains;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:39 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(schema = "resume_schema")
@Builder
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private CountryEntity countryEntity;
    @Column(nullable = false,unique = true)
    private String cityName;



}
