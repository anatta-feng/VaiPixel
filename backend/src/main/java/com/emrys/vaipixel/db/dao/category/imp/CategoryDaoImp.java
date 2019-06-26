package com.emrys.vaipixel.db.dao.category.imp;

import com.emrys.vaipixel.db.dao.category.ICategoryDao;
import com.emrys.vaipixel.db.mapper.CategoryMapper;
import com.emrys.vaipixel.db.model.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.List;

public class CategoryDaoImp implements ICategoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImp.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean isCategoryExist(Category category) {
        return category != null && categoryMapper.getCategoryById(category.getCategoryId()) != null;
    }

    @Override
    public boolean isCategoryExist(long categoryId) {
        return categoryMapper.getCategoryById(categoryId) != null;
    }

    @Override
    public Category getCategoryByName(@NonNull String name) {
        return categoryMapper.getCategoryByName(name);
    }

    @Override
    public Category getCategoryById(long categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }

    @Override
    public PageInfo<Category> getCategories(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categories = categoryMapper.getAllCategory();
        return new PageInfo<>(categories);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public void addCategoryIfNotExist(Category category) {
        if (category == null) {
            LOGGER.info("addCategoryIfNotExist category is null");
        } else if (isCategoryExist(category)) {
            LOGGER.info("addCategoryIfNotExist category has exist");
        } else {
            categoryMapper.addCategory(category);
        }
    }
}
