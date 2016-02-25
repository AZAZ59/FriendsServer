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
    public UserData login(
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "vk_id", defaultValue = "") Long vk_id
    ) {
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
            if (fromEmail != null&&fromVK==null) {
                return fromEmail;
            }
            else if (fromEmail == null&&fromVK!=null) {
                return fromVK;
            }else {
                fromEmail.setId(fromVK.getId());
                dataService.persist(fromEmail);
                dataService.delete(fromVK);
                return fromEmail;
            }
        }
    }
}
//return new Data(counter.incrementAndGet(),String.format(template, name));

