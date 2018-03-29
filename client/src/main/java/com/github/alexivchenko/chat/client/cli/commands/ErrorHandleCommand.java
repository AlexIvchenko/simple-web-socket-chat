package com.github.alexivchenko.chat.client.cli.commands;

/**
 * @author Alex Ivchenko
 */
public class ErrorHandleCommand implements Command {
    private final Command delegate;
    private final ErrorHandler handler;

    public ErrorHandleCommand(Command delegate, ErrorHandler handler) {
        this.delegate = delegate;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            delegate.run();
        } catch (Exception e) {
            handler.handle(e);
        }
    }
}
