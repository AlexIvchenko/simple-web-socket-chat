package com.github.alexivchenko.chat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
@ToString
public class OutputMessage {
    private String sender;
    private String text;
}
