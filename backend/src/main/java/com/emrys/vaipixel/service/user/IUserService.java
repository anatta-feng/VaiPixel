package com.emrys.vaipixel.service.user;

import com.emrys.vaipixel.db.model.User;

public interface IUserService {
    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return 用户基本信息
     */
    User login(String userName, String password);

    /**
     * 根据用户 Id 获取用户信息
     * @param id 用户 id
     * @return 用户信息
     */
    User getUserInfoById(long id);

    /**
     * 更新用户信息
     * @param user 更新后的用户信息
     */
    void updateUserInfo(User user);

    /**
     * 添加用户
     * @param user 用户信息
     */
    void addUser(User user);
}
