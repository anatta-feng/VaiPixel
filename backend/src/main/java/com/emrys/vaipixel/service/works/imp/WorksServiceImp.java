package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.service.works.IWorkEditor;
import com.emrys.vaipixel.service.works.IWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksServiceImp implements IWorksService {

    @Autowired
    private WorkMapper workMapper;


    @Override
    public void addWork(Work work) {
        IWorkEditor workEditor = IWorkEditor.processWork(work);
        workEditor.addWork(work);
    }

    @Override
    public void deleteWorkById(long workId) {

    }

    @Override
    public List<Work> getAllWorks() {
        return workMapper.getAll();
    }

    @Override
    public List<Work> getWorkByCond() {
        return null;
    }

    @Override
    public void addedWorkClick(long workId) {

    }

    @Override
    public List<Work> getWorkInCategory(long categoryId) {
        return null;
    }

    @Override
    public List<Work> getWorkWithTag(long tagId) {
        return null;
    }

    @Override
    public void updateWork(Work work) {

    }
}
