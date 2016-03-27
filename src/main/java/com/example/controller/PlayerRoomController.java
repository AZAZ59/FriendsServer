package com.example.controller;

import com.example.entity.PlayerRoom;
import com.example.entity.UserData;
import com.example.service.RoomService;
import com.example.service.UserDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.ListIterator;

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
            ,@RequestParam(value = "isOpen", defaultValue = "true", required = false) boolean isOpen
            ,@RequestParam(value = "place")String place
            ,@RequestParam(value = "name")String name
    )
    {
        PlayerRoom playerRoom = new PlayerRoom();
        UserData creator = userService.findById(creatorId);

        playerRoom.setStartTime(System.currentTimeMillis());

        playerRoom.setCreator(creator.getId());
        playerRoom.getUsers().add(creator.getId());
        creator.setRoom(playerRoom.getId());

        playerRoom.setOpen(isOpen);

        playerRoom.setPlace(place);

        playerRoom.setName(name);

        userService.persist(creator);
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
        playerRoom.getUsers().add(playerId);
        roomService.persist(playerRoom);
        return playerRoom;
    }
    @RequestMapping("/room/getById")
    public PlayerRoom addPlayer(
            @RequestParam(value = "roomId") String roomId){
        return roomService.findById(roomId);
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
    @RequestMapping("/room/removeMember")
    public int removeMember(
            @RequestParam(value = "roomId") String roomId,
            @RequestParam(value = "playerId") String playerId
    ){
        PlayerRoom playerRoom=roomService.findById(roomId);
        UserData player=userService.findById(playerId);
        ListIterator<String> dat =playerRoom.getUsers().listIterator();
        while(dat.hasNext()){
            String  cur=dat.next();
            if(player.getId()==cur){
                dat.previous();
                dat.remove();
            }
        }
        if(playerRoom.getUsers().size()==0){
            roomService.delete(playerRoom.getId());
            return 0;
        }else {
            //playerRoom.setEndTime(System.currentTimeMillis());
            roomService.persist(playerRoom);
            return playerRoom.getUsers().size();
        }
    }




    @RequestMapping("/room/all")
    public ArrayList<PlayerRoom> getAll() {
        return roomService.getAll();
    }


}
//return new Data(counter.incrementAndGet(),String.format(template, name));

