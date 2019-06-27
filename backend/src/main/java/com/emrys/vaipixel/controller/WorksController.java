package com.emrys.vaipixel.controller;

import com.emrys.vaipixel.db.model.Category;
import com.emrys.vaipixel.db.model.Tag;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.service.works.IWorksService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.emrys.vaipixel.constant.Constant.Params.*;
import static com.emrys.vaipixel.db.enums.WorkTypeEnum.photo;
import static com.emrys.vaipixel.db.enums.WorkTypeEnum.video;

@RestController
public class WorksController extends BaseController {

    private IWorksService worksService;

    @Autowired
    public WorksController(IWorksService worksService) {
        this.worksService = worksService;
    }

    @RequestMapping("/works")
    public PageInfo<Work> works(
            @RequestParam(value = KEY_PAGE_NUM, required = false, defaultValue = DEFAULT_PAGE_NUM)
                    int pageNum,
            @RequestParam(value = KEY_PAGE_SIZE, required = false, defaultValue = DEFAULT_PAGE_SIZE)
                    int pageSize) {
        return worksService.getWorks(pageNum, pageSize);
    }

    @RequestMapping("/photo/{workId}")
    public Work photoDetail(@PathVariable long workId) {
        return worksService.getWorkDetail(workId, photo);
    }

    @RequestMapping("/video/{workId}")
    public Work videoDetail(@PathVariable long workId) {
        return worksService.getWorkDetail(workId, video);
    }

    @RequestMapping("/categories")
    public PageInfo<Category> categories(
            @RequestParam(value = KEY_PAGE_NUM, required = false, defaultValue = DEFAULT_PAGE_NUM)
                    int pageNum,
            @RequestParam(value = KEY_PAGE_SIZE, required = false, defaultValue = DEFAULT_PAGE_SIZE)
                    int pageSize) {
        return worksService.getCategories(pageNum, pageSize);
    }

    @RequestMapping("/tags")
    public PageInfo<Tag> tags(
            @RequestParam(value = KEY_PAGE_NUM, required = false, defaultValue = DEFAULT_PAGE_NUM)
                    int pageNum,
            @RequestParam(value = KEY_PAGE_SIZE, required = false, defaultValue = DEFAULT_PAGE_SIZE)
                    int pageSize) {
        return worksService.getTags(pageNum, pageSize);
    }

}
