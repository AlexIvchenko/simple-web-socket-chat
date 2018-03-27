package com.github.alexivchenko.chat.client;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class ClientApplication {
    private final static String URL = "ws://localhost:8080/chat";

    public static void main(String[] args) throws Exception {
        String url;
        if (args.length == 1) {
            url = "ws://" + args[0] + "/chat";
        } else {
            url = URL;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new CustomStompSessionHandler();
        ListenableFuture<StompSession> future = stompClient.connect(url, sessionHandler);

        StompSession session = future.get();

        while(true) {
            String line = scanner.nextLine();
            session.send("/app/chat", new Message(name, line));
        }
    }
}
