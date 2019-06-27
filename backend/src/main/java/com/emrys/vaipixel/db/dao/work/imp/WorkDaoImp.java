package com.emrys.vaipixel.db.dao.work.imp;

import com.emrys.vaipixel.db.dao.work.IWorkDao;
import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.mapper.PhotoMapper;
import com.emrys.vaipixel.db.mapper.VideoMapper;
import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.db.model.Video;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.dto.cond.WorkCond;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkDaoImp implements IWorkDao {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public boolean isWorkExist(Work work) {
        return work == null || workMapper.getWorkById(work.getWorkId()) != null;
    }

    @Override
    public boolean isWorkExist(long workId) {
        return workMapper.getWorkById(workId) != null;
    }

    @Override
    public Work getWorkByName(String name) {
        return null;
    }

    @Override
    public Work getWorkById(long workId, WorkTypeEnum type) {
        return workMapper.getWorkByIdAndType(workId, type);
    }

    @Override
    public PageInfo<Work> getWorks(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Work> works = workMapper.getWorks();
        return new PageInfo<>(works);
    }

    @Override
    public PageInfo<Work> getWorkWithCategory(long categoryId, int pageNum, int pageSize) {
        WorkCond workCond = new WorkCond.Builder()
                .withCategoryId(categoryId)
                .build();
        return getWorksWithCond(workCond, pageNum, pageSize);
    }

    @Override
    public PageInfo<Work> getWorksWithCond(WorkCond cond, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Work> works = workMapper.getWorksByCond(cond);
        return new PageInfo<>(works);
    }

    @Override
    public void addWork(Work work) {
        workMapper.insertWork(work);
    }

    @Override
    public void addPhotoWork(Photo photo) {
        workMapper.insertWork(photo);
        photoMapper.insertPhoto(photo);
    }

    @Override
    public void addVideoWork(Video video) {
        workMapper.insertWork(video);
        videoMapper.insertVideo(video);
    }

    @Override
    public void updateWork(Work work) {

    }

    @Override
    public void deleteWorkById(long workId) {
        workMapper.deleteWorkById(workId);
    }
}
