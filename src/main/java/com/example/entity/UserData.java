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

    public UserData() {}

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getVkId() != null ? getVkId().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    private UUID id;

    private Long vkId;
    private String email;

    public UserData(Long vkId) {
        this.vkId = vkId; this.id=UUID.randomUUID();
    }

    public UserData(String email) {
        this.email = email;this.id=UUID.randomUUID();
    }

    public UserData(Long vkId, String email) {
        this.vkId = vkId;
        this.email = email;
        this.id=UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
