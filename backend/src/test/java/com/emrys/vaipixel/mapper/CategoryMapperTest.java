package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.db.mapper.CategoryMapper;
import com.emrys.vaipixel.db.model.Category;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class CategoryMapperTest extends BaseTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testInsert() {
        Category category = new Category();
        category.setCategoryName(String.valueOf(RandomString.make(3)));
        categoryMapper.addCategory(category);
    }
}
