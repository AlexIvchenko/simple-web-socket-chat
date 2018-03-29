package com.github.alexivchenko.chat.client.cli.mvc.controller.api;

/**
 * @author Alex Ivchenko
 */
public interface AuthController {
    default void signUp(String username, String password) {
        throw new UnsupportedOperationException();
    }

    default void signIn(String username, String password) {
        throw new UnsupportedOperationException();
    }

    default void signOut() {
        throw new UnsupportedOperationException();
    }
}
