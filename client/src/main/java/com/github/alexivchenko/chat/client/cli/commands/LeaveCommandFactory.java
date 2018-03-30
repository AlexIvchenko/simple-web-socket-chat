package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;

/**
 * @author Alex Ivchenko
 */
public class LeaveCommandFactory implements CommandFactory {
    private final ContextHolder holder;

    public LeaveCommandFactory(ContextHolder holder) {
        this.holder = holder;
    }

    @Override
    public Command build(String str) {
        return new LeaveCommand(holder);
    }

    @Override
    public boolean supports(String str) {
        return str.startsWith(":leave");
    }

    @Override
    public boolean isAvailable() {
        UserState state = holder.context().getUserState();
        return state == UserState.CHATTING_WITH_USER || state == UserState.CHATTING_IN_CHANNEL;
    }
}
