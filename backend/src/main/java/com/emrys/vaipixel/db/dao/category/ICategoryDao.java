package com.emrys.vaipixel.db.dao.category;

import com.emrys.vaipixel.db.model.Category;
import com.github.pagehelper.PageInfo;

public interface ICategoryDao {

    boolean isCategoryExist(Category category);

    boolean isCategoryExist(String categoryName);

    boolean isCategoryExist(long categoryId);

    Category getCategoryByName(String name);

    Category getCategoryById(long categoryId);

    PageInfo<Category> getCategories(int pageNum, int pageSize);

    void addCategory(Category category);

    void addCategoryIfNotExist(String categoryName);
}
