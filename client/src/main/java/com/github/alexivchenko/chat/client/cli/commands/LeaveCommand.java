package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;

/**
 * @author Alex Ivchenko
 */
public class LeaveCommand implements Command {
    private final ContextHolder holder;

    public LeaveCommand(ContextHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        holder.context().setUserState(UserState.INITIAL);
        holder.context().setReceiver(null);
    }
}
