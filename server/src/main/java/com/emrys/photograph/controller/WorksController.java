package com.emrys.photograph.controller;

import com.emrys.photograph.pojo.Work;
import com.emrys.photograph.pojo.WrapperPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorksController {

    @RequestMapping("/works")
    public WrapperPojo<List<Work>> works() {
        return null;
    }

}
