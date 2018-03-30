package com.github.alexivchenko.chat.client.service.feign;

import com.github.alexivchenko.chat.client.User;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

/**
 * @author Alex Ivchenko
 */
public interface UserClient {
    @RequestLine("GET")
    @Headers("Content-Type: application/json")
    List<User> users();
}
