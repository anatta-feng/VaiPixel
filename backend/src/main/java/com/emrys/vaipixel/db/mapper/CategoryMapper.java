package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {

    @Select("SELECT * FROM t_category ")
    List<Category> getAllCategory();

    @Select("SELECT * FROM t_category WHERE category_id = #{id}")
    Category getCategoryById(long id);

    @Insert("INSERT INTO t_category(category_name) VALUES (#{categoryName})")
    void addCategory(Category category);

    @Delete("DELETE FROM t_category WHERE category_id = #{id}")
    void deleteCategoryById(long id);
}
