package com.emrys.vaipixel.controller;

import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.model.Category;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.db.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorksController {

    @Autowired
    private PhotoMapper photoMapper;

    @RequestMapping("/works")
    public List<Photo> works() {

        return photoMapper.getAll();
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
