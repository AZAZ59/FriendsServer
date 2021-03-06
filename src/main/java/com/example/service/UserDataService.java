package com.example.service;

import com.example.entity.UserData;

import java.util.ArrayList;

public interface UserDataService {

    boolean persist(UserData data);

    UserData findByVk_id(String Vk_id);
    UserData findByEmail(String Email);
    UserData findById(String Id);
    ArrayList<UserData> getAll();

    void delete(UserData userData);
}