package com.emrys.vaipixel.service.user;

import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.db.model.User;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

import static org.junit.Assert.*;

public class UserServiceTest extends BaseTest {

    @Autowired
    private IUserService userService;

    @Test
    public void login() {
        User user = userService.login("Emrys", "asdasfsaf");
        System.out.println(user);
    }

    @Test
    public void getUserInfoById() {
    }

    @Test
    public void updateUserInfo() {
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(RandomUtils.nextLong(0, 99999));
        user.setUserName("Emrys");
        user.setEmail("1@fxcdev.com");
        user.setNickName("Emrys");
        user.setAvatarUrl("sad");
        user.setPassword("asdasfsaf");
        userService.addUser(user);
    }
}