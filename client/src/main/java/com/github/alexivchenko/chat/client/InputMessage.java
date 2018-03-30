package com.github.alexivchenko.chat.client;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
public class InputMessage {
    private String sender;
    private String text;
}
