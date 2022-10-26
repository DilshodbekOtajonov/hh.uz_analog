package com.example.project_blueprint.dto.user;


import com.example.project_blueprint.dto.GenericDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDto extends GenericDto {
    private Long id;
    private String fullName;
    private String password;
    private String email;
    private String phoneNumber;
    private String jobSearchArea;
    private String socialMedia;

}
