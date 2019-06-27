package com.emrys.vaipixel.db.dao.work;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.db.model.Video;
import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.dto.cond.WorkCond;
import com.github.pagehelper.PageInfo;

public interface IWorkDao {

    boolean isWorkExist(Work work);

    boolean isWorkExist(long workId);

    Work getWorkByName(String name);

    Work getWorkById(long workId, WorkTypeEnum type);

    PageInfo<Work> getWorks(int pageNum, int pageSize);

    PageInfo<Work> getWorkWithCategory(long categoryId, int pageNum, int pageSize);

    PageInfo<Work> getWorksWithCond(WorkCond cond, int pageNum, int pageSize);

    void addWork(Work work);

    void addPhotoWork(Photo photo);

    void addVideoWork(Video video);

    void updateWork(Work work);

    void deleteWorkById(long workId);
}
