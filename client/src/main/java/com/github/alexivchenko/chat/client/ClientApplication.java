package com.github.alexivchenko.chat.client;

import com.github.alexivchenko.chat.client.cli.ContextHolderImpl;
import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.commands.*;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;
import com.github.alexivchenko.chat.client.handlers.CustomStompSessionHandler;
import com.github.alexivchenko.chat.client.handlers.NotificationHandler;
import com.github.alexivchenko.chat.client.handlers.UserTopicHandler;
import com.github.alexivchenko.chat.client.service.ChannelClientAdapter;
import com.github.alexivchenko.chat.client.service.ChannelService;
import com.github.alexivchenko.chat.client.service.UserService;
import com.github.alexivchenko.chat.client.service.UserClientAdapter;
import com.github.alexivchenko.chat.client.service.feign.ChannelClient;
import com.github.alexivchenko.chat.client.service.feign.UserClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class ClientApplication {
    private final static String URL = "ws://localhost:8080/chat";

    public static void main(String[] args) throws Exception {
        String url;
        if (args.length > 0) {
            url = "ws://" + args[0] + "/chat";
        } else {
            System.err.println("connecting to localhost");
            url = URL;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User currentUser = new User(name);

        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompHeaders stompHeaders = new StompHeaders();
        stompHeaders.add("username", name);
        stompHeaders.add("password", "pass");
        ListenableFuture<StompSession> future = stompClient.connect(url, new WebSocketHttpHeaders(), stompHeaders, new CustomStompSessionHandler());
        StompSession session = future.get();


        session.subscribe("/topic/notifications", new NotificationHandler());
        UserTopicHandler userHandler = new UserTopicHandler();

//        session.subscribe("/topic/direct/" + name + "/messages", userHandler);

        Sender sender = new SenderImpl(session, currentUser);

        ContextHolder holder = new ContextHolderImpl();

        userHandler.addListener(event -> {
            String senderUsername = event.get().getSender();
            String receiverUsername = holder.context().getReceiver().getUsername();
            String currentUsername = currentUser.getUsername();
            if (holder.context().getUserState() == UserState.CHATTING_WITH_USER &&
                    (senderUsername.equals(receiverUsername) || senderUsername.equals(currentUsername))) {
                System.out.println(senderUsername + ": " + event.get().getText());
            }
        });

        Feign.Builder feign = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.NONE);

        UserClient userClient = feign
                .target(UserClient.class, "http://localhost:8080/api/users");

        ChannelClient channelClient = feign
                .target(ChannelClient.class, "http://localhost:8080/api/channels");

        UserService userService = new UserClientAdapter(userClient);
        ChannelService channelService = new ChannelClientAdapter(channelClient);

        holder.context().setUserState(UserState.INITIAL);
        CommandBuilder builder = ListFactoriesCommandBuilder.builder()
                .add(new SendCommandFactory(holder, sender))
                .add(new StartChattingWithUserCommandFactory(holder))
                .add(new LeaveCommandFactory(holder))
                .add(new ListUsersCommandFactory(holder, userService, list -> {
                    list.forEach(user -> System.out.println(user.getUsername()));
                }))
                .add(new ListChannelsCommandFactory(holder, channelService, set -> {
                    set.forEach(channel -> System.out.println(channel.getName()));
                }))
                .add(new CreateChannelCommandFactory(holder, channelService))
                .build();

        CommandInterpreter interpreter = new CommandInterpreterImpl(builder, new SendAsDefaultCommandGenerator());

        while (true) {
            String command = scanner.nextLine();
            interpreter.interpret(command);
        }

//        CommandLineInterface cli = new CommandLineInterface(sender);
//        cli.run();
    }
}
