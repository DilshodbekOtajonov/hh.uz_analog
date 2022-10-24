package com.example.project_blueprint.dto;

import javax.validation.constraints.NotNull;

public class VerifyTokenRequestDTO {

    @NotNull
    private String email;

    @NotNull
    private Integer otp;

//    private Boolean rememberMe;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

//    public Boolean getRememberMe() {
//        return rememberMe;
//    }

//    public void setRememberMe(Boolean rememberMe) {
//        this.rememberMe = rememberMe;
//    }
}
