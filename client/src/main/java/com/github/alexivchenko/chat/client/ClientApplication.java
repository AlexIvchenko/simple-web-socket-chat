package com.github.alexivchenko.chat.client;

import com.github.alexivchenko.chat.client.cli.CommandLineInterface;

public class ClientApplication {
    private final static String URL = "ws://localhost:8080/chat";

    public static void main(String[] args) throws Exception {
        CommandLineInterface cli = new CommandLineInterface();
        cli.run();
//        String url;
//        if (args.length > 0) {
//            url = "ws://" + args[0] + "/chat";
//        } else {
//            System.err.println("connecting to localhost");
//            url = URL;
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String name = scanner.nextLine();
//
//        WebSocketClient client = new StandardWebSocketClient();
//
//        WebSocketStompClient stompClient = new WebSocketStompClient(client);
//        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//
//        StompHeaders stompHeaders = new StompHeaders();
//        stompHeaders.add("username", name);
//        stompHeaders.add("password", "pass");
//        ListenableFuture<StompSession> future = stompClient.connect(url, new WebSocketHttpHeaders(), stompHeaders, new CustomStompSessionHandler());
//        StompSession session = future.get();
//        session.subscribe("/topic/notifications", new NotificationHandler());
//        while(true) {
//            String line = scanner.nextLine();
//            session.send("/app/chat", new Message(name, line));
//        }
    }
}
