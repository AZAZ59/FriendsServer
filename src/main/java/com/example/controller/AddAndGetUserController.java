package com.example.controller;

import com.example.entity.UserData;
import com.example.service.UserDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by azaz on 22/01/16.
 */
@RestController
public class AddAndGetUserController {
    private static final Logger LOG = Logger.getLogger(AddAndGetUserController.class);

    @Autowired
    private UserDataService dataService;

    @RequestMapping("/login")
    public UserData login(
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "vk_id", defaultValue = "") Long vk_id
    ) {
        if(email.isEmpty()) email=null;
        LOG.info("email |" + email + "| id " + vk_id);
        UserData data = new UserData(vk_id, email);
        UserData fromEmail = null;
        UserData fromVK = null;
        if (email != null) {
            fromEmail = dataService.findByEmail(email);
        }
        if (vk_id != null) {
            fromVK = dataService.findByVk_id(vk_id);
        }
        LOG.info(fromEmail);
        LOG.info(fromVK);

        if (fromEmail == null && fromVK == null) {
            dataService.persist(data);
            return data;
        } else {
            if (fromEmail != null && fromVK == null) {
                return fromEmail;
            } else /*if (fromEmail == null&&fromVK!=null)*/ {
                return fromVK;
            }
            /*if(email!=null&&vk_id!=null){
                if (fromEmail != null && fromVK == null) {
                    fromEmail.setVkId(vk_id);
                    dataService.persist(fromEmail);
                    return fromEmail;
                } else if (fromEmail == null&&fromVK!=null) {
                    fromVK.setEmail(email);
                    dataService.persist(fromVK);
                    return fromVK;
                } else {

                }
            }else {*/

            /*}else {
                fromEmail.setId(fromVK.getId());
                dataService.persist(fromEmail);
                dataService.delete(fromVK);
                return fromEmail;
            }*/
        }
    }

    @RequestMapping("/setScore")
    public void setScore(
            @RequestParam(value="userData")UserData userData,
            @RequestParam(value="userData")long score
    ){
        UserData data = dataService.findById(userData.getId());
        data.setScore(score);
        dataService.persist(data);
    }

    @RequestMapping("/all")
    public ArrayList<UserData> getAll(){
        return dataService.getAll();
    }

}
//return new Data(counter.incrementAndGet(),String.format(template, name));

