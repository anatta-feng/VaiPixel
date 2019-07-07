package com.emrys.vaipixel.controller;

import com.emrys.vaipixel.http.request.LoginRequest;
import com.emrys.vaipixel.http.response.LoginResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseV1Controller {

    @RequestMapping("/login")
    public LoginResponse login(LoginRequest request) {
        System.out.println("login");
        LoginResponse response = new LoginResponse();
        return response;
    }

    @RequestMapping("/userInfo")
    public void getUserInfo() {
        System.out.println("getUserInfo");
    }
}
