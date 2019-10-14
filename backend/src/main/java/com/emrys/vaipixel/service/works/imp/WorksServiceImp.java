package com.emrys.vaipixel.service.works.imp;

import com.emrys.vaipixel.db.dao.category.ICategoryDao;
import com.emrys.vaipixel.db.dao.tag.ITagDao;
import com.emrys.vaipixel.db.dao.user.IUserDao;
import com.emrys.vaipixel.db.dao.work.IWorkDao;
import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.Category;
import com.emrys.vaipixel.db.model.Tag;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.exception.VaiException;
import com.emrys.vaipixel.http.request.SubmitWorkRequest;
import com.emrys.vaipixel.service.works.IWorkEditor;
import com.emrys.vaipixel.service.works.IWorksService;
import com.emrys.vaipixel.third.service.IThirdObjectStorageService;
import com.emrys.vaipixel.utils.SnowflakeIdWorker;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import static com.emrys.vaipixel.constant.Constant.ErrorStatus.*;

@Service
class WorksServiceImp implements IWorksService {

    private IWorkDao workDao;

    private ICategoryDao categoryDao;

    private ITagDao tagDao;

    private IUserDao userDao;

    private SnowflakeIdWorker idWorker;

    private IThirdObjectStorageService objectStorageService;

    @Autowired
    public void setWorkDao(IWorkDao workDao) {
        this.workDao = workDao;
    }

    @Autowired
    public void setCategoryDao(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Autowired
    public void setTagDao(ITagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Autowired
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setIdWorker(SnowflakeIdWorker idWorker) {
        this.idWorker = idWorker;
    }

    @Autowired
    public void setObjectStorageService(IThirdObjectStorageService objectStorageService) {
        this.objectStorageService = objectStorageService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addWork(SubmitWorkRequest submit) {
        if (submit == null) {
            throw new VaiException(FAIL_REQUEST_PARAM);
        } else if (!userDao.isUserExist(submit.getAuthorId())) {
            throw new VaiException(FAIL_USER_NOT_EXIST);
        } else {
            categoryDao.addCategoryIfNotExist(submit.getCategory());
            if (submit.getTags() != null) {
                for (String tag : submit.getTags()) {
                    tagDao.addTagIfNotExist(tag);
                }
            }
            Work work = new Work();
            // TODO create work
            work.setId(idWorker.nextId());
            IWorkEditor workEditor = IWorkEditor.processWork(work);
            workEditor.addWork(work);
            objectStorageService.removeResourceDeadline(submit.getKey());
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
    public Work getWorkDetail(long workId, WorkTypeEnum type) {
        return workDao.getWorkById(workId, type);
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

    @Override
    public PageInfo<Category> getCategories(int pageNum, int pageSize) {
        return categoryDao.getCategories(pageNum, pageSize);
    }

    @Override
    public PageInfo<Tag> getTags(int pageNum, int pageSize) {
        return tagDao.getTags(pageNum, pageSize);
    }
}
