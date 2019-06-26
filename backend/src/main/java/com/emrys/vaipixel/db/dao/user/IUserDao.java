package com.emrys.vaipixel.db.dao.user;

import com.emrys.vaipixel.db.model.User;

public interface IUserDao {

    boolean isUserExist(User user);

    boolean isUserExist(long userId);

    User getUserById(long UserId);

    void addUser(User user);
}
