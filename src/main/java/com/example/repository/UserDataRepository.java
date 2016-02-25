package com.example.repository;

import com.example.entity.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserDataRepository extends CrudRepository<UserData,UUID> {

    List<UserData> findByVk_id(Long Vk_id);
    List<UserData> findByEmail(String Email);

}