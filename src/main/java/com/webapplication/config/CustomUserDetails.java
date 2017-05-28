package com.webapplication.config;

import com.webapplication.entities.Admin;
import com.webapplication.entities.Parent;
import com.webapplication.entities.Provider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
public class CustomUserDetails implements UserDetails {
    String username;
    String password;
    Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Parent byEmail) {
        this.username = byEmail.getEmail();
        this.password = byEmail.getPassword();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_PARENT"));
        this.authorities = authorities;
    }

    public CustomUserDetails(Provider byEmail) {
        this.username = byEmail.getEmail();
        this.password = byEmail.getPassword();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_PROVIDER"));
        this.authorities = authorities;
    }

    public CustomUserDetails(Admin byEmail) {
        this.username = byEmail.getEmail();
        this.password = byEmail.getPassword();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        this.authorities = authorities;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
