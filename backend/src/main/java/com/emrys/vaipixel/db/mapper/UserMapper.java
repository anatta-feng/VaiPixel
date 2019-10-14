package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.User;
import com.emrys.vaipixel.dto.cond.UserCond;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT id, user_name, nick_name, avatar_url FROM t_user WHERE id = #{id}")
    User getUserById(@Param("id") long id);

    @Insert("INSERT INTO t_user(id, user_name, nick_name, avatar_url, email, password) " +
            "VALUES (#{userId}, #{userName}, #{nickName}, #{avatarUrl}, #{email}, #{password})")
    void addUser(User user);

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    void deleteUserById(long id);

    User getUserInfoByCond(@Param("userName") String userName, @Param("password") String password);
}
