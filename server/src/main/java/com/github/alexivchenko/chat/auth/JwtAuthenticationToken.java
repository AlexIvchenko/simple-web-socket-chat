package com.github.alexivchenko.chat.auth;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @author Alex Ivchenko
 */
@Getter
public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private final Long userId;
    private final String username;

    public JwtAuthenticationToken(Long userId, String username) {
        super(null);
        this.username = username;
        this.userId = userId;
        setAuthenticated(false);
    }

    @Override
    public String getName() {
        return getUsername();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }
}
