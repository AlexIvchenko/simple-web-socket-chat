package com.github.alexivchenko.chat.auth;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Alex Ivchenko
 */
@Component
public class WebSocketAuthenticatorService {
    public JwtAuthenticationToken getAuthenticatedOrFail(final String  username, final String password)
            throws AuthenticationException {
        if (username == null || username.trim().isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Username was null or empty.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Password was null or empty.");
        }
        JwtAuthenticationToken auth = new JwtAuthenticationToken(new Random().nextLong(), username);
        auth.setAuthenticated(true);
        return auth;
    }
}
