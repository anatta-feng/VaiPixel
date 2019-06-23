package com.emrys.vaipixel.service.works;

import com.emrys.vaipixel.db.model.Work;

import java.util.List;

public interface IWorksService {

    /**
     * 添加作品
     *
     * @param work 待添加的作品信息
     */
    void addWork(Work work);

    /**
     * 根据作品 Id 删除作品
     *
     * @param workId 作品 Id
     */
    void deleteWorkById(long workId);

    /**
     * 获取所有的作品
     *
     * @return
     */
    List<Work> getAllWorks();

    /**
     * 根据某一条件获取作品
     * @return
     */
    List<Work> getWorkByCond();

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
    List<Work> getWorkInCategory(long categoryId);

    /**
     * 获取带有某 tag 的所有作品
     *
     * @param tagId tag id
     * @return 带有某一 tag 的作品信息
     */
    List<Work> getWorkWithTag(long tagId);

    /**
     * 更新作品
     *
     * @param work 待更新的作品信息
     */
    void updateWork(Work work);

}
