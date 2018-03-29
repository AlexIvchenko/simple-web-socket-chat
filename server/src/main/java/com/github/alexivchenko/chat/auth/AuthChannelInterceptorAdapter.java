package com.github.alexivchenko.chat.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Component
public class AuthChannelInterceptorAdapter extends ChannelInterceptorAdapter {
    private static final String USERNAME_HEADER = "username";
    private static final String PASSWORD_HEADER = "password";
    private final WebSocketAuthenticatorService webSocketAuthenticatorService;

    public AuthChannelInterceptorAdapter(final WebSocketAuthenticatorService webSocketAuthenticatorService) {
        this.webSocketAuthenticatorService = webSocketAuthenticatorService;
    }

    @Override
    public Message<?> preSend(final Message<?> message, final MessageChannel channel) throws AuthenticationException {
        log.info("enter: message: {}, message channel: {}", message, channel);
        final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (StompCommand.CONNECT == accessor.getCommand()) {
            log.info("there is connect command");
            String username = accessor.getFirstNativeHeader(USERNAME_HEADER);
            String password = accessor.getFirstNativeHeader(PASSWORD_HEADER);
            JwtAuthenticationToken user = webSocketAuthenticatorService.getAuthenticatedOrFail(username, password);
            accessor.setUser(user);
        }
        log.info("exit");
        return message;
    }
}
