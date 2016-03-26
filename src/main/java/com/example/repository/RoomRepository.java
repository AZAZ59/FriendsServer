package com.example.repository;

import com.example.entity.PlayerRoom;
import com.example.entity.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<PlayerRoom,String> {

}