package com.github.alexivchenko.chat.client;

import lombok.*;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@AllArgsConstructor
public class Channel {
    private String name;
}
