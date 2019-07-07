package com.emrys.vaipixel.service.works;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.Category;
import com.emrys.vaipixel.db.model.Tag;
import com.emrys.vaipixel.db.model.Work;
import com.github.pagehelper.PageInfo;

public interface IWorksService {

    /**
     * 添加作品
     *
     * @param work 待添加的作品信息
     */
    void addWork(String key, Work work);

    /**
     * 根据作品 Id 删除作品
     *
     * @param workId 作品 Id
     */
    void deleteWorkById(long workId);

    /**
     * 获取所有的作品
     *
     * @param pageNum 第几页
     * @param pageSize 每页多少
     * @return
     */
    PageInfo<Work> getWorks(int pageNum, int pageSize);

    /**
     * 获取作品详情
     * @param workId workId
     * @return work
     */
    Work getWorkDetail(long workId, WorkTypeEnum type);

    /**
     * 增加作品点击量
     *
     * @param workId 作品 id
     */
    void addedWorkClick(long workId);

    /**
     * 获取某一分类下的所有作品
     *
     * @param categoryId 分类 id
     * @return 分类下的作品信息
     */
    PageInfo<Work> getWorkInCategory(long categoryId, int pageNum, int pageSize);

    /**
     * 获取带有某 tag 的所有作品
     *
     * @param tagId tag id
     * @return 带有某一 tag 的作品信息
     */
    PageInfo<Work> getWorkWithTag(long tagId, int pageNum, int pageSize);

    /**
     * 更新作品
     *
     * @param work 待更新的作品信息
     */
    void updateWork(Work work);

    /**
     * 获取所有的分类
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Category> getCategories(int pageNum, int pageSize);

    PageInfo<Tag> getTags(int pageNum, int pageSize);

}
