package com.example.service;

import com.example.entity.PlayerRoom;
import com.example.repository.RoomRepository;
import com.example.repository.UserDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by AZAZ on 26.03.2016.
 */

@Service("RoomService")
public class RoomServiceImpl implements RoomService {

    private static final Logger LOG = LoggerFactory.getLogger(RoomServiceImpl.class);

    private final RoomRepository dataRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    @Override
    public boolean persist(PlayerRoom room) {
        try {

            dataRepository.save(room);
            return true;
        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public PlayerRoom findById(String Id) {
        return dataRepository.findOne(Id);
    }

    @Override
    public ArrayList<PlayerRoom> getAll() {
        ArrayList<PlayerRoom> out=new ArrayList<>();
        dataRepository.findAll().forEach(t->out.add(t));
        return out;
    }

    @Override
    public void delete(PlayerRoom room) {
        dataRepository.delete(room);
    }

    @Override
    public void delete(String Id) {
        dataRepository.delete(dataRepository.findOne(Id));
    }

}
