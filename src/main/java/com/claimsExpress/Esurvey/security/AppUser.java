package com.claimsExpress.Esurvey.security;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name="CORE_USER")
public class AppUser implements UserDetails {
    private static final long serialVersionUID = 3961396589345698205L;

    @Id
    @Column(name="ID")
    private String userId;

    private String pwd;


    @Column(name = "ACTIVE_FLAG")
    private Integer activeFlag;


    @Column(name="PWD_ENCRYPTED")
    private String password;


    public AppUser() {}




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }





}
