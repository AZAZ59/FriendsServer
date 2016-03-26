package com.example.service;

import com.example.entity.PlayerRoom;
import com.example.entity.UserData;

import java.util.ArrayList;
import java.util.Set;

public interface RoomService {

    boolean persist(PlayerRoom room);

    PlayerRoom findById(String Id);
    ArrayList<PlayerRoom> getAll();

    void delete(PlayerRoom room);
    void delete(String Id);
}