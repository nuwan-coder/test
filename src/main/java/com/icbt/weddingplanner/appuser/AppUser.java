package com.icbt.weddingplanner.appuser;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "appUser_sequence",
            sequenceName = "appUser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appUser_sequence"
    )
    private Long id;
    private  String firstName;
    private  String lastName;
    private  String username;
    private  String email;
    private  String nic;
    private  String contactNo;
    private  String password;
    private  AppUserRole appUserRole;


    public AppUser(AppUser appUser) {
        this.id = appUser.id;
        this.firstName = appUser.firstName;
        this.lastName = appUser.lastName;
        this.username = appUser.username;
        this.email = appUser.email;
        this.nic = appUser.nic;
        this.contactNo = appUser.contactNo;
        this.password = appUser.password;
        this.appUserRole = appUser.appUserRole;
    }

    public AppUser(String firstName,
                   String lastName,
                   String username,
                   String email,
                   String nic,
                   String contactNo,
                   String password,
                   AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.nic = nic;
        this.contactNo = contactNo;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
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
