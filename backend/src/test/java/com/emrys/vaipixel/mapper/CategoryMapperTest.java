package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.db.mapper.CategoryMapper;
import com.emrys.vaipixel.db.model.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryMapperTest extends BaseTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testInsert() {
        Category category = new Category();
        category.setCategoryName("风景");
        categoryMapper.addCategory(category);
    }
}
