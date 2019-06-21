package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.service.works.IWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksServiceImp implements IWorksService {

    @Autowired
    private PhotoMapper photoMapper;


    @Override
    public List<Photo> getAllWorks() {
        System.out.println(this.getClass().getName());
        return photoMapper.getAll();
    }
}
