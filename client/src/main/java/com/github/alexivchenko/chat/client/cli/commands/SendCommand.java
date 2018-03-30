package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.User;

/**
 * @author Alex Ivchenko
 */
public interface SendCommand extends Command {
    static SendToUserCommand.MessageStageBuilder to(User user) {
        return SendToUserCommand.builder()
                .to(user);
    }

    static SendToChannelCommand.MessageStageBuilder to(Channel channel) {
        return SendToChannelCommand.builder()
                .to(channel);
    }
}
