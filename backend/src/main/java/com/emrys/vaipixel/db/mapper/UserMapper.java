package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT id, name, email FROM user")
    List<User> getAll();

    @Insert("INSERT INTO user(name, email) VALUES(#{name}, #{email})")
    void insert(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(long id);
}
