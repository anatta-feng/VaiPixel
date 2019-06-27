package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.db.model.Video;
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
    @Results({
            @Result(column = "author_id", property = "author", one = @One(select = "com.emrys.vaipixel.db.mapper.UserMapper.getUserById")),
            @Result(column = "category_id", property = "category", one = @One(select = "com.emrys.vaipixel.db.mapper.CategoryMapper.getCategoryById")),
            @Result(column = "work_id", property = "tags", many = @Many(select = "com.emrys.vaipixel.db.mapper.TagMapper.getWorkTags")),
            @Result(column = "work_id", property = "workId"),
            @Result(column = "large_url", property = "image.largeUrl"),
            @Result(column = "medium_url", property = "image.mediumUrl"),
            @Result(column = "small_url", property = "image.smallUrl"),
            @Result(column = "thumb_url", property = "image.thumbUrl"),
    })
    @TypeDiscriminator(javaType = WorkTypeEnum.class, column = "type", cases = {
            @Case(value = "photo", type = Photo.class, results = {
                    @Result(column = "camera", property = "cameraParameter.camera"),
                    @Result(column = "lens", property = "cameraParameter.lens"),
                    @Result(column = "focal_length", property = "cameraParameter.focalLength"),
                    @Result(column = "aperture", property = "cameraParameter.aperture"),
                    @Result(column = "iso", property = "cameraParameter.iso"),
                    @Result(column = "shutter", property = "cameraParameter.shutter"),
            }),
            @Case(value = "video", type = Video.class, results = {
                    @Result(column = "device_name", property = "deviceName"),
                    @Result(column = "play_url", property = "playUrl")
            })
    })
    List<Work> getWorks();

    @Select("SELECT work.work_id, title, description, created_time, updated_time, width, height, type, large_url, " +
            "medium_url, small_url, thumb_url, author_id, category_id, like_count, page_view, user_view, camera, " +
            "lens, focal_length, aperture, iso, shutter, device_name, play_url " +
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
