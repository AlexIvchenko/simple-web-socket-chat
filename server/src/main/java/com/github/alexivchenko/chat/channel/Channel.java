package com.github.alexivchenko.chat.channel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "name")
public class Channel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
}
