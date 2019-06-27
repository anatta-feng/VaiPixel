package com.emrys.vaipixel.db.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    private long userId;
    private String userName;
    private String nickName;
    private String avatarUrl;
    private String email;
    private String password;
    private Timestamp joinTime;
    private Timestamp lastSeenTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getJoinTime() {
        return joinTime.getTime();
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

    public long getLastSeenTime() {
        return lastSeenTime.getTime();
    }

    public void setLastSeenTime(Timestamp lastSeenTime) {
        this.lastSeenTime = lastSeenTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
