package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * Created by azaz on 25/02/16.
 */
@Entity
public class UserData implements DomainObject {
    @Id
    private String id;

    @Override
    public String toString() {
        return "UserData{" +
                "id='" + id + '\'' +
                ", vkId=" + vkId +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @ManyToOne
    PlayerRoom room;

    private Long vkId;
    private String email;
    private String message;
    long score;

    public PlayerRoom getRoom() {
        return room;
    }

    public void setRoom(PlayerRoom room) {
        this.room = room;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

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
