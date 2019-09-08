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
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class CategoryDaoImp implements ICategoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImp.class);

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryDaoImp(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public boolean isCategoryExist(Category category) {
        return category != null && categoryMapper.getCategoryById(category.getCategoryId()) != null;
    }

    @Override
    public boolean isCategoryExist(String categoryName) {
        return !StringUtils.isEmpty(categoryName) && getCategoryByName(categoryName) != null;
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
    public void addCategoryIfNotExist(String categoryName) {
        if (StringUtils.isEmpty(categoryName)) {
            LOGGER.info("addCategoryIfNotExist category is null");
        } else if (isCategoryExist(categoryName)) {
            LOGGER.info("addCategoryIfNotExist category has exist");
        } else {
            categoryMapper.addCategory(new Category(categoryName));
        }
    }
}
