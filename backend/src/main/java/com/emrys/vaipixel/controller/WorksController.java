package com.emrys.vaipixel.controller;

import com.emrys.vaipixel.db.model.Category;
import com.emrys.vaipixel.db.model.Tag;
import com.emrys.vaipixel.db.model.Work;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WorksController {

    @RequestMapping("/works")
    public List<Work> works() {
        ArrayList<Work> objects = new ArrayList<>();
        objects.add(new Work());
        return objects;
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
