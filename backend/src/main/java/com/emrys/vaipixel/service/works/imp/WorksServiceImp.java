package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.dao.category.ICategoryDao;
import com.emrys.vaipixel.db.dao.tag.ITagDao;
import com.emrys.vaipixel.db.dao.user.IUserDao;
import com.emrys.vaipixel.db.dao.work.IWorkDao;
import com.emrys.vaipixel.db.model.Tag;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.exception.VaiException;
import com.emrys.vaipixel.service.works.IWorkEditor;
import com.emrys.vaipixel.service.works.IWorksService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.emrys.vaipixel.constant.Constant.ErrorStatus.*;

@Service
public class WorksServiceImp implements IWorksService {

    @Autowired
    private IWorkDao workDao;

    @Autowired
    private ICategoryDao categoryDao;

    @Autowired
    private ITagDao tagDao;

    @Autowired
    private IUserDao userDao;

    @SuppressWarnings("unchecked")
    @Override
    public void addWork(Work work) {
        if (work == null) {
            throw new VaiException(FAIL_REQUEST_PARAM);
        } else if (workDao.isWorkExist(work)) {
            throw new VaiException(FAIL_WORK_ALREADY_EXIST);
        } else if (!userDao.isUserExist(work.getAuthor())) {
            throw new VaiException(FAIL_USER_NOT_EXIST);
        } else {
            categoryDao.addCategoryIfNotExist(work.getCategory());
            if (work.getTags() != null) {
                for (Tag tag : work.getTags()) {
                    tagDao.addTagIfNotExist(tag);
                }
            }
            IWorkEditor workEditor = IWorkEditor.processWork(work);
            workEditor.addWork(work);
        }
    }

    @Override
    public void deleteWorkById(long workId) {
        if (!workDao.isWorkExist(workId)) {
            throw new VaiException(FAIL_WORK_NOT_EXIST);
        } else {
            workDao.deleteWorkById(workId);
        }
    }

    @Override
    public PageInfo<Work> getWorks(int pageNum, int pageSize) {
        return workDao.getWorks(pageNum, pageSize);
    }

    @Override
    public void addedWorkClick(long workId) {

    }

    @Override
    public PageInfo<Work> getWorkInCategory(long categoryId, int pageNum, int pageSize) {
        return workDao.getWorkWithCategory(categoryId, pageNum, pageSize);
    }

    @Override
    public PageInfo<Work> getWorkWithTag(long tagId, int pageNum, int pageSize) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void updateWork(Work work) {
        IWorkEditor workEditor = IWorkEditor.processWork(work);
        workEditor.updateWork(work);
    }
}
