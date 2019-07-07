package com.emrys.vaipixel.service.user.imp;

import com.emrys.vaipixel.db.mapper.UserMapper;
import com.emrys.vaipixel.db.model.User;
import com.emrys.vaipixel.exception.VaiException;
import com.emrys.vaipixel.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.emrys.vaipixel.constant.Constant.ErrorStatus.FAIL_REQUEST_PARAM;
import static com.emrys.vaipixel.constant.Constant.ErrorStatus.FAIL_USER_LOGIN_ERROR;

@Service
public class UserServiceImp implements IUserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String userName, String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            throw VaiException.withStatus(FAIL_REQUEST_PARAM);
        }
        User user = userMapper.getUserInfoByCond(userName, password);
        if (user == null) {
            throw VaiException.withStatus(FAIL_USER_LOGIN_ERROR);
        }
        return user;
    }

    @Override
    public User getUserInfoById(long id) {
        return null;
    }

    @Override
    public void updateUserInfo(User user) {

    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
