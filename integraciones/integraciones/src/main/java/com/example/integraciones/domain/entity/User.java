package com.example.integraciones.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @ApiModelProperty(value = "username", example = "nvillar")
    private String username;
    @ApiModelProperty(value = "password", example = "1234564")
    private String password;
    @ApiModelProperty(value = "state", example = "true")
    private Boolean state;
    @ApiModelProperty(value = "roles")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(m -> m.getRol().getName()).collect(Collectors.toList())
                .stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserPropertiesPreConfigurated.ACCOUNT_EXPIRED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserPropertiesPreConfigurated.ACCOUNT_LOCKED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserPropertiesPreConfigurated.CREDENTIALS_EXPIRED;
    }

    @Override
    public boolean isEnabled() {
        return UserPropertiesPreConfigurated.ENABLED;
    }

    interface UserPropertiesPreConfigurated {
        boolean ENABLED = true;
        boolean CREDENTIALS_EXPIRED = false;
        boolean ACCOUNT_LOCKED = false;
        boolean ACCOUNT_EXPIRED = false;
    }
}
