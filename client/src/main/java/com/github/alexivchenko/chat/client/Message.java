package com.github.alexivchenko.chat.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String from;
    private String text;
}
