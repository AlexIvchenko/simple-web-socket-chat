package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.Sender;
import com.github.alexivchenko.chat.client.User;

/**
 * @author Alex Ivchenko
 */
public class SendToUserCommand implements SendCommand {
    private final Sender sender;
    private final User user;
    private final Message message;

    public SendToUserCommand(Sender sender, User user, Message message) {
        this.sender = sender;
        this.user = user;
        this.message = message;
    }

    public static UserStageBuilder builder() {
        return user -> message -> sender -> new SendToUserCommand(sender, user, message);
    }

    @Override
    public void run() {
        sender.send(user, message);
    }

    public interface UserStageBuilder {
        MessageStageBuilder to(User user);
    }

    public interface MessageStageBuilder {
        SenderStageBuilder send(Message message);
    }

    public interface SenderStageBuilder {
        SendCommand using(Sender sender);
    }
}
