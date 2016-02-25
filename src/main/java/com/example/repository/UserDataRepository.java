package com.example.repository;

import com.example.entity.Data;
import com.example.entity.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDataRepository extends CrudRepository<UserData,Long> {

    List<UserData> findByVk_id(Long Vk_id);
    List<UserData> findByEmail(String Email);

}