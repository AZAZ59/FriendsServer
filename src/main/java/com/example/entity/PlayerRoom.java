package com.example.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Created by AZAZ on 26.03.2016.
 */
@Entity

public class PlayerRoom implements DomainObject {
    @Id
    String id;

    @Cascade(CascadeType.ALL)
    @OneToMany
    List<UserData> users;
    boolean open;
    //@OneToOne
    UserData creator;
    Long startTime;
    Long endTime;
    String place;
    String name;

    public PlayerRoom() {
        this.id=UUID.randomUUID().toString();
        users=new ArrayList<>();
        this.endTime=-1L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
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
