package com.github.alexivchenko.chat.client.cli;

import com.github.alexivchenko.chat.client.cli.context.Context;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;

/**
 * @author Alex Ivchenko
 */
public class ContextHolderImpl implements ContextHolder {
    private ContextImpl context = new ContextImpl();

    @Override
    public Context context() {
        return context;
    }
}
