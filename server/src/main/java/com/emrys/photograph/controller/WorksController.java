package com.emrys.photograph.controller;

import com.emrys.photograph.pojo.Category;
import com.emrys.photograph.pojo.Tag;
import com.emrys.photograph.pojo.Work;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorksController {

    @RequestMapping("/works")
    public List<Work> works() {
        return null;
    }

    @RequestMapping("/categories")
    public List<Category> categories() {
        return null;
    }

    @RequestMapping("/tags")
    public List<Tag> tags() {
        return null;
    }

}
