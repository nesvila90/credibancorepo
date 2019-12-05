package com.example.integraciones.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserApp implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @ApiModelProperty(value = "username", example = "nvillar")
    @Column(unique = true)
    private String username;

    @ApiModelProperty(value = "password", example = "1234564")
    private String password;

    @ApiModelProperty(value = "roles")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

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
        boolean CREDENTIALS_EXPIRED = true;
        boolean ACCOUNT_LOCKED = true;
        boolean ACCOUNT_EXPIRED = true;
    }
}
