package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.dto.cond.WorkCond;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkMapper {

    @Select("SELECT work.work_id, title, description, created_time, updated_time, width, height, type, large_url, " +
            "medium_url, small_url, thumb_url, author_id, category_id, like_count, page_view, user_view " +
            "FROM t_work AS work " +
            "LEFT JOIN t_photo ON t_photo.work_id = work.work_id " +
            "LEFT JOIN t_video ON t_video.work_id = work.work_id ")
    @ResultMap("com.emrys.vaipixel.db.mapper.WorkMapper.WorkResultMap")
    List<Work> getWorks();

    @Select("SELECT work.work_id, title, description, created_time, updated_time, width, height, type, large_url, " +
            "medium_url, small_url, thumb_url, author_id, category_id, like_count, page_view, user_view " +
            "FROM t_work AS work " +
            "LEFT JOIN t_photo ON t_photo.work_id = work.work_id " +
            "LEFT JOIN t_video ON t_video.work_id = work.work_id " +
            "WHERE work.work_id = #{workId}")
    @ResultMap("com.emrys.vaipixel.db.mapper.WorkMapper.WorkResultMap")
    Work getWorkById(long workId);

    List<Work> getWorksByCond(WorkCond cond);

    @Insert("INSERT INTO t_work(work_id, title, description, width, height, type, large_url, medium_url, small_url, " +
            "thumb_url, category_id, author_id) " +
            "VALUES " +
            "(#{workId}, #{title}, #{description}, #{width}, #{height}, #{type}, #{image.largeUrl}, #{image.mediumUrl}, " +
            "#{image.smallUrl}, #{image.thumbUrl}, #{category.categoryId}, #{author.userId})")
    void insertWork(Work work);

    @Delete("DELETE FROM t_work WHERE work_id = #{id}")
    void deleteWorkById(long id);

}
