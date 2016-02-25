package com.example.service;

import com.example.entity.UserData;
import com.example.repository.UserDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserDataService")
public class UserDataServiceImpl implements UserDataService {

    private static final Logger LOG = LoggerFactory.getLogger(UserDataServiceImpl.class);

    private final UserDataRepository dataRepository;

    @Autowired
    public UserDataServiceImpl(UserDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public boolean persist(UserData data) {
        try {
            dataRepository.save(data);
            return true;
        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
    }



    @Override
    public UserData findByVk_id(Long Vk_id) {
        return dataRepository.findByVkId(Vk_id).get(0);
    }

    @Override
    public UserData findByEmail(String Email) {
        return dataRepository.findByEmail(Email).get(0);
    }

    @Override
    public void delete(UserData userData) {
        dataRepository.delete(userData);
    }


}