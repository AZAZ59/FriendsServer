package com.example.repository;

import com.example.entity.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDataRepository extends CrudRepository<UserData,String> {

    List<UserData> findByVkId(String Vk_id);
    List<UserData> findByEmail(String Email);

}