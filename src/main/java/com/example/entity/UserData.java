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
        if (getVkId() != null ? !getVkId().equals(userData.getVkId()) : userData.getVkId() != null) return false;
        return getEmail() != null ? getEmail().equals(userData.getEmail()) : userData.getEmail() == null;

    }

    public UserData() {
        this.id=UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getVkId() != null ? getVkId().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Id
    private String id;

    private Long vkId;
    private String email;

    public UserData(Long vkId) {
        this();
        this.vkId = vkId;
    }

    public UserData(String email) {
        this();
        this.email = email;
    }

    public UserData(Long vkId, String email) {
        this();
        this.vkId = vkId;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVkId() {
        return vkId;
    }

    public void setVkId(Long vkId) {
        this.vkId = vkId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
