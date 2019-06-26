package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT user_id, user_name, nick_name, avatar_url FROM t_user WHERE user_id = #{id}")
    User getUserById(@Param("id") long id);

    @Insert("INSERT INTO t_user(user_id, user_name, email, password) " +
            "VALUES (#{userId}, #{userName}, #{email}, #{password})")
    void addUser(User user);

    @Delete("DELETE FROM t_user WHERE user_id = #{id}")
    void deleteUserById(long id);
}
