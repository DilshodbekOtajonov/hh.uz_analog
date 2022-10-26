package com.example.project_blueprint.domains.auth;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomUserDetails implements UserDetails {

    private Long id;
    private AuthRole role;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String password;
    private String mobilePhoneNumber;
    private String jobSearchArea;
    private String socialNetworks;
    private boolean blocked;
    private boolean active;
    private Set<GrantedAuthority> authorities;

    public CustomUserDetails(User user) {
        this.id = user.getId();
        this.role = this.getRole();
        this.fullName = this.getFirstName()+" "+this.getLastName();
        this.email = this.getEmail();
        this.password = this.getPassword();
        this.mobilePhoneNumber = this.getMobilePhoneNumber();
        this.jobSearchArea = this.getJobSearchArea();
        this.socialNetworks = this.getSocialNetworks();
        processAuthorities(user);
    }

    public void getFullName(User user)
    {
            System.out.println(this.getFirstName() + " " + this.getLastName());
    }

    private void processAuthorities(User user) {
        authorities = new HashSet<>();
        AuthRole role = this.getRole();
        if (Objects.isNull(role)) return;
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
        if (Objects.isNull(role.getPermissions())) return;
        role.getPermissions().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getCode())));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.active;
    }
}
