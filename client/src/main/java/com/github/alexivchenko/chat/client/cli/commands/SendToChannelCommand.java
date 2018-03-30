package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.Sender;

/**
 * @author Alex Ivchenko
 */
public class SendToChannelCommand implements SendCommand {
    private final Sender sender;
    private final Channel channel;
    private final Message message;

    public SendToChannelCommand(Sender sender, Channel channel, Message message) {
        this.sender = sender;
        this.channel = channel;
        this.message = message;
    }

    public static ChannelStageBuilder builder() {
        return channel -> message -> sender -> new SendToChannelCommand(sender, channel, message);
    }

    @Override
    public void run() {
        sender.send(channel, message);
    }

    public interface ChannelStageBuilder {
        MessageStageBuilder to(Channel channel);
    }

    public interface MessageStageBuilder {
        SenderStageBuilder send(Message message);
    }

    public interface SenderStageBuilder {
        SendCommand using(Sender sender);
    }
}
