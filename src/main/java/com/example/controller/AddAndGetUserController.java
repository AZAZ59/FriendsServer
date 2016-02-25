package com.example.controller;

import com.example.entity.UserData;
import com.example.service.UserDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by azaz on 22/01/16.
 */
@RestController
public class AddAndGetUserController {
    private static final Logger LOG = Logger.getLogger(DataController.class);

    @Autowired
    private UserDataService dataService;

    @RequestMapping("/login")
    public UserData greeting(
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "vk_id", defaultValue = "-1") Long vk_id
    ) {
        UserData data = new UserData(vk_id, email);
        LOG.trace("email |"+email+"| id "+vk_id);
        if (!email.isEmpty() && vk_id == -1) {
            //has email  and has not id
            UserData dat = dataService.findByEmail(email);
            if (dat != null) {
                return dat;
            } else {
                dataService.persist(data);
                return data;
            }

        } else if (email.isEmpty() && vk_id != -1) {
            //hasn`t email and has id
            UserData dat = dataService.findByVk_id(vk_id);
            if (dat != null) {
                return dat;
            } else {
                dataService.persist(data);
                return data;
            }
        } else {
            //has both val
            UserData u1= dataService.findByEmail(email);
            UserData u2 = dataService.findByVk_id(vk_id);

            data.setEmail(u1.getEmail());
            data.setVkId(u2.getVkId());

            dataService.delete(u1);
            dataService.delete(u2);
            dataService.persist(data);
            return data;//
        }
        //return new Data(counter.incrementAndGet(),String.format(template, name));
    }
}
