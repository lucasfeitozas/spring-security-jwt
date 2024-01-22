package br.com.feitozadev.authentication.domain.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum UserRole {
    USER(List.of(new SimpleGrantedAuthority("ROLE_USER"))),
    ADMIN(List.of(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN")));

    private final List<SimpleGrantedAuthority> authorities;

    UserRole(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
