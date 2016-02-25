package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by azaz on 25/02/16.
 */
@Entity
public class UserData implements DomainObject {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData)) return false;

        UserData userData = (UserData) o;

        if (!getId().equals(userData.getId())) return false;
        if (getVk_id() != null ? !getVk_id().equals(userData.getVk_id()) : userData.getVk_id() != null) return false;
        return getEmail() != null ? getEmail().equals(userData.getEmail()) : userData.getEmail() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getVk_id() != null ? getVk_id().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    private UUID id;

    private Long vk_id;
    private String email;

    public UserData(Long vk_id) {
        this.vk_id = vk_id; this.id=UUID.randomUUID();
    }

    public UserData(String email) {
        this.email = email;this.id=UUID.randomUUID();
    }

    public UserData(Long vk_id, String email) {
        this.vk_id = vk_id;
        this.email = email;
        this.id=UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getVk_id() {
        return vk_id;
    }

    public void setVk_id(Long vk_id) {
        this.vk_id = vk_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
