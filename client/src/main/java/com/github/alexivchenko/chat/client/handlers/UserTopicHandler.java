package com.github.alexivchenko.chat.client.handlers;

import com.github.alexivchenko.chat.client.InputMessage;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Ivchenko
 */
public class UserTopicHandler implements StompFrameHandler {
    private final List<EventListener<Event<InputMessage>>> listeners = new ArrayList<>();

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return InputMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        InputMessage message = (InputMessage) payload;
        Event<InputMessage> event = new Event<>(message);
        listeners.forEach(handler -> handler.handle(event));
    }

    public void addListener(EventListener<Event<InputMessage>> listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener<Event<InputMessage>> listener) {
        listeners.remove(listener);
    }
}
