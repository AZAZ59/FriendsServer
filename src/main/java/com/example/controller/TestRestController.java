package com.example.controller;

import com.example.entity.Data;
import com.example.entity.PlayerRoom;
import com.example.entity.UserData;
import com.example.service.RoomService;
import com.example.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserDataService userService;

    @RequestMapping("/greeting")
    public Data greeting(@RequestParam(value = "data", defaultValue = "World") String name) {
        PlayerRoom room1= new PlayerRoom();
        PlayerRoom room2= new PlayerRoom();

        UserData user1=new UserData();
        UserData user2=new UserData();
        UserData user3=new UserData();

        user1.setEmail("user1@email.ru");
        user1.setRoom(room1);

        user2.setEmail("user2@email.ru");
        user2.setRoom(room1);

        user3.setEmail("user3@email.ru");
        user3.setRoom(room2);

        room1.setPlace("place1");
        room1.setOpen(true);
        room1.setStartTime(System.currentTimeMillis());
        room1.setCreator(user1);
        room1.setName("room1");
        room1.getUsers().add(user1);
        room1.getUsers().add(user2);

        room2.setPlace("place2");
        room2.setOpen(true);
        room2.setStartTime(System.currentTimeMillis()+123456789L);
        room2.setCreator(user3);
        room2.getUsers().add(user3);
        room2.setName("room2");

        userService.persist(user1);
        userService.persist(user2);
        userService.persist(user3);

        roomService.persist(room1);
        roomService.persist(room2);

        return new Data(counter.incrementAndGet(),String.format(template, name));
    }
}
