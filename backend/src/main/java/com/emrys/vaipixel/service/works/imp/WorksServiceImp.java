package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.service.works.IWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksServiceImp implements IWorksService {

    @Autowired
    private WorkMapper workMapper;


    @Override
    public List<Work> getAllWorks() {
        return workMapper.getAll();
    }
}
