package com.emrys.vaipixel.controller;

import com.emrys.vaipixel.controller.base.BaseV1Controller;
import com.emrys.vaipixel.db.model.Category;
import com.emrys.vaipixel.service.works.IWorksService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.emrys.vaipixel.constant.Constant.Params.*;

@RestController
public class CategoryController extends BaseV1Controller {

    private IWorksService worksService;

    @Autowired
    public void setWorksService(IWorksService worksService) {
        this.worksService = worksService;
    }

    @RequestMapping("/categories")
    public PageInfo<Category> categories(
            @RequestParam(value = KEY_PAGE_NUM, required = false, defaultValue = DEFAULT_PAGE_NUM)
                    int pageNum,
            @RequestParam(value = KEY_PAGE_SIZE, required = false, defaultValue = DEFAULT_PAGE_SIZE)
                    int pageSize) {
        return worksService.getCategories(pageNum, pageSize);
    }
}
