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
/*
{"id":"3e24a087-cf7e-4b9d-b540-ac16cd6a07aa","vkId":null,"email":"user1@ya.ru","message":null,"score":0}
{"id":"6e8f9e89-01a5-4405-bdd7-70cec4fea660","vkId":null,"email":"user2@ya.ru","message":null,"score":0}
{"id":"f3b744c5-544b-48aa-aa2b-969fe12cf2f3","vkId":null,"email":"user3@ya.ru","message":null,"score":0}


d0cbab2e-c916-40da-a908-3693b5119eb8

d75a6052-efc7-4eea-a5be-7a1c191dbfa6

*/
/*
        PlayerRoomController room= new PlayerRoomController();
        AddAndGetUserController user= new AddAndGetUserController();
                UserData user1=user.login("user1@asd.ru","123");

        UserData user2=user.login("user2@asd.ru","234");

        PlayerRoom room1 = room.create(user1.getId(), true,"place1","room1");
        room.addPlayer(room1.getId(),user2.getId());

        room.create(user.login("user3@qwe.ru","345").getId(),true,"place2","room2");

        /*PlayerRoom room1= new PlayerRoom();
        PlayerRoom room2= new PlayerRoom();

        UserData user1=new UserData();
        UserData user2=new UserData();
        UserData user3=new UserData();

        user1.setEmail("user1@email.ru");
        user2.setEmail("user2@email.ru");
        user3.setEmail("user3@email.ru");

        userService.persist(user1);
        userService.persist(user2);
        userService.persist(user3);
        roomService.persist(room1);
        roomService.persist(room2);


        user1.setRoom(room1);
        user2.setRoom(room1);
        user3.setRoom(room2);

        room1.setPlace("place1");
        room1.setOpen(true);
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
*/
        return new Data(counter.incrementAndGet(),String.format(template, name));
    }
}
