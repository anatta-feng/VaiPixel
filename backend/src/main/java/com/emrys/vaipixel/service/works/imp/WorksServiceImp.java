package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.mapper.WorkMapper;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.exception.VaiException;
import com.emrys.vaipixel.service.works.IWorkEditor;
import com.emrys.vaipixel.service.works.IWorksService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.emrys.vaipixel.constant.Constant.ErrorCode.*;
import static com.emrys.vaipixel.utils.UserUtils.isUserExist;
import static com.emrys.vaipixel.utils.WorkUtils.isWorkExist;

@Service
public class WorksServiceImp implements IWorksService {

    @Autowired
    private WorkMapper workMapper;

    @SuppressWarnings("unchecked")
    @Override
    public void addWork(Work work) {
        if (work == null) {
            throw new VaiException(FAIL_REQUEST_PARAM, "Input is null");
        } else if (isWorkExist(work)) {
            throw new VaiException(FAIL_WORK_ALREADY_EXIST, "Work has already exist");
        } else if (!isUserExist(work.getAuthor())) {
            throw new VaiException(FAIL_USER_NOT_EXIST, "User not exist");
        } else {
            IWorkEditor workEditor = IWorkEditor.processWork(work);
            workEditor.addWork(work);
        }
    }

    @Override
    public void deleteWorkById(long workId) {
        if (!isWorkExist(workId)) {
            throw new VaiException(FAIL_WORK_NOT_EXIST, "Work not exist");
        } else {
            workMapper.deleteWorkById(workId);
        }
    }

    @Override
    public PageInfo<Work> getWorks(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Work> works = workMapper.getWorks();
        return new PageInfo<>(works);
    }

    @Override
    public PageInfo<Work> getWorkByCond() {
        return null;
    }

    @Override
    public void addedWorkClick(long workId) {

    }

    @Override
    public PageInfo<Work> getWorkInCategory(long categoryId) {
        return null;
    }

    @Override
    public PageInfo<Work> getWorkWithTag(long tagId) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void updateWork(Work work) {
        IWorkEditor workEditor = IWorkEditor.processWork(work);
        workEditor.updateWork(work);
    }
}
