package com.emrys.vaipixel.utils;

import com.emrys.vaipixel.db.mapper.UserMapper;
import com.emrys.vaipixel.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUtils {
    @Autowired
    private static UserMapper userMapper;

    public static boolean isUserExist(User user) {
        return user != null && userMapper.getUserById(user.getUserId()) != null;
    }

    public static boolean isUserExist(long userId) {
        return userMapper.getUserById(userId) != null;
    }
}
