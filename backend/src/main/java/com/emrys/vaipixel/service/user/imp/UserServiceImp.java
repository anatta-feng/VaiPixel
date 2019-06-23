package com.emrys.vaipixel.service.user.imp;

import com.emrys.vaipixel.db.mapper.UserMapper;
import com.emrys.vaipixel.db.model.User;
import com.emrys.vaipixel.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImp implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
//        if (StringUtils.isB)

        return null;
    }

    @Override
    public User getUserInfoById(long id) {
        return null;
    }

    @Override
    public void updateUserInfo(User user) {

    }
}
