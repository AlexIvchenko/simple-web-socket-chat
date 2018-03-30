package com.github.alexivchenko.chat.client.cli.context;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.UserState;

/**
 * @author Alex Ivchenko
 */
public interface Context {
    void setUserState(UserState userState);

    UserState getUserState();

    User getReceiver();

    void setReceiver(User receiver);

    Channel getChannel();
}
