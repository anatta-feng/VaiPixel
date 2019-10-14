package com.emrys.vaipixel.db.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class User implements Serializable {
    private long id;
    private String userName;
    private String nickName;
    private String avatarUrl;
    private String email;
    private String password;
    private Timestamp joinTime;
    private Timestamp lastSeenTime;
}
