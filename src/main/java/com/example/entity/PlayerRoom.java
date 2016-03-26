package com.example.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Created by AZAZ on 26.03.2016.
 */
@Entity

public class PlayerRoom {
    @Id
    String id;

    @OneToMany
    List<UserData> users;

    //@OneToOne
    UserData creator;


    public PlayerRoom() {
        this.id=UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserData> getUsers() {
        return users;
    }

    public void setUsers(List<UserData> users) {
        this.users = users;
    }

    public UserData getCreator() {
        return creator;
    }

    public void setCreator(UserData creator) {
        this.creator = creator;
    }
}
