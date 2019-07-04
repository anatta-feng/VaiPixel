package com.emrys.vaipixel.controller;

import com.emrys.vaipixel.http.request.LoginRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseV1Controller {

    @RequestMapping("/login")
    public void login(LoginRequest request) {
        System.out.println("login");
    }

    @RequestMapping("/userInfo")
    public void getUserInfo() {
        System.out.println("getUserInfo");
    }
}
