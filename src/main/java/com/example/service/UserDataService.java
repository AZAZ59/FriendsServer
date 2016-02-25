package com.example.service;

import com.example.entity.UserData;

public interface UserDataService {

    public boolean persist(UserData data);

    UserData findByVk_id(Long Vk_id);
    UserData findByEmail(String Email);

    void delete(UserData userData);
}