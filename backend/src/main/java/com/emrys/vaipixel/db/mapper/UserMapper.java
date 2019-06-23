package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT user_id, user_name FROM t_user WHERE user_id = #{id}")
    User getUserById(@Param("id") long id);
}
