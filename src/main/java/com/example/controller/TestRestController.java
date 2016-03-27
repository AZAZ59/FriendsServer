package com.example.controller;

import com.example.entity.Data;
import com.example.entity.PlayerRoom;
import com.example.entity.UserData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by azaz on 22/01/16.
 */
@RestController
public class TestRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Data greeting(@RequestParam(value = "data", defaultValue = "World") String name) {
        PlayerRoomController room= new PlayerRoomController();
        AddAndGetUserController user= new AddAndGetUserController();

        UserData user1=user.login("user1@asd.ru",123L);
        UserData user2=user.login("user2@asd.ru",234L);

        PlayerRoom room1 = room.create(user1.getId(), true,"place1");
        room.addPlayer(room1.getId(),user2.getId());
        room.create(user.login("user3@qwe.ru",345L).getId(),true,"place2");

        return new Data(counter.incrementAndGet(),String.format(template, name));
    }
}
