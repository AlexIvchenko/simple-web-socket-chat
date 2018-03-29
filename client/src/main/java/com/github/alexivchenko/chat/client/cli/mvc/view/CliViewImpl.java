package com.github.alexivchenko.chat.client.cli.mvc.view;

/**
 * @author Alex Ivchenko
 */
public class CliViewImpl implements CliView {
    private final Object lock = new Object();

    public void println(String content) {
        synchronized (lock) {
            System.out.println(content);
        }
    }
}
