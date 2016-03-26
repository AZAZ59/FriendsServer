package com.example.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;

/**
 * Created by AZAZ on 26.03.2016.
 */
@Entity

public class PlayerRoom {
    @Id
    Long id;

    @OneToMany
    ArrayList<UserData> users;

    @OneToOne
    UserData creator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<UserData> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserData> users) {
        this.users = users;
    }

    public UserData getCreator() {
        return creator;
    }

    public void setCreator(UserData creator) {
        this.creator = creator;
    }
}
