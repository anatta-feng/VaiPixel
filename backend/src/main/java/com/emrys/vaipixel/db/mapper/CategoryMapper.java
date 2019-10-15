package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM t_category ")
    List<Category> getAllCategory();

    @Select("SELECT * FROM t_category WHERE id = #{id}")
    Category getCategoryById(long id);

    @Select("SELECT * FROM t_category WHERE name = #{name}")
    Category getCategoryByName(String name);

    @Insert("INSERT INTO t_category(name) VALUES (#{name})")
    void addCategory(Category category);

    @Delete("DELETE FROM t_category WHERE id = #{id}")
    void deleteCategoryById(long id);
}
