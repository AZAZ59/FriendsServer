package com.example.controller;

import com.example.entity.PlayerRoom;
import com.example.service.RoomService;
import com.example.service.UserDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by azaz on 22/01/16.
 */
@RestController
public class PlayerRoomController {
    private static final Logger LOG = Logger.getLogger(PlayerRoomController.class);

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserDataService userService;

    @RequestMapping("/room/create")
    public PlayerRoom create(
            @RequestParam(value = "creatorId") String creatorId
            ,@RequestParam(value = "isOpen", defaultValue = "true", required = false) boolean isOpen)
    {
        PlayerRoom playerRoom = new PlayerRoom();
        playerRoom.setStartTime(System.currentTimeMillis());
        playerRoom.setCreator(userService.findById(creatorId));
        playerRoom.setOpen(isOpen);
        roomService.persist(playerRoom);
        return playerRoom;
    }

    @RequestMapping("/room/addPlayer")
    public PlayerRoom addPlayer(
            @RequestParam(value = "roomId") String roomId,
            @RequestParam(value = "playerId") String playerId
    )
    {
        PlayerRoom playerRoom=roomService.findById(roomId);
        playerRoom.getUsers().add(userService.findById(playerId));
        roomService.persist(playerRoom);
        return playerRoom;
    }

    @RequestMapping("/room/endGame")
    public PlayerRoom endGame(
            @RequestParam(value = "roomId") String roomId
    ){
        PlayerRoom playerRoom=roomService.findById(roomId);
        playerRoom.setEndTime(System.currentTimeMillis());
        roomService.persist(playerRoom);
        return playerRoom;
    }



    @RequestMapping("/room//all")
    public ArrayList<PlayerRoom> getAll() {
        return roomService.getAll();
    }


}
//return new Data(counter.incrementAndGet(),String.format(template, name));

