package com.github.alexivchenko.chat.client.cli.commands;

/**
 * @author Alex Ivchenko
 */
public class ErrorHandleCommandFactory implements CommandFactory {
    private final CommandFactory delegate;
    private final ErrorHandler handler;

    public ErrorHandleCommandFactory(CommandFactory delegate, ErrorHandler handler) {
        this.delegate = delegate;
        this.handler = handler;
    }

    @Override
    public Command build(String str) {
        return new ErrorHandleCommand(delegate.build(str), handler);
    }

    @Override
    public boolean supports(String str) {
        return delegate.supports(str);
    }

    @Override
    public boolean isAvailable() {
        return delegate.isAvailable();
    }
}
