package com.example.project_blueprint.dto.user;

import com.example.project_blueprint.dto.Dto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto implements Dto {
    @NotBlank(message = "Full name can not be blank")
    private String fullName;

    @NotBlank(message = "password can not be blank")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
            message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = "email can not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message = "Email is invalid")
    private String email;

    @NotBlank(message = "Phone number can not be blank")
    private String phoneNumber;

    @NotBlank(message = "Job search area can not be blank")
    private String jobSearchArea;

    @NotBlank(message = "Social media can not be blank")
    private String socialMedia;


}
