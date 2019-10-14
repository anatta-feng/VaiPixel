package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Video;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoMapper {

    @Select("SELECT * FROM t_work AS work INNER JOIN t_video AS video ON video.work_id = work.id " +
            "WHERE video.work_id = #{work_id}")
    @Results({
            @Result(column = "author_id", property = "author", one = @One(select = "com.emrys.vaipixel.db.mapper.UserMapper.getUserById")),
            @Result(column = "category_id", property = "category", one = @One(select = "com.emrys.vaipixel.db.mapper.CategoryMapper.getCategoryById")),
            @Result(column = "work_id", property = "tags", many = @Many(select = "com.emrys.vaipixel.db.mapper.TagMapper.getWorkTags")),
            @Result(column = "id", property = "workId"),
            @Result(column = "large_url", property = "image.largeUrl"),
            @Result(column = "medium_url", property = "image.mediumUrl"),
            @Result(column = "small_url", property = "image.smallUrl"),
            @Result(column = "thumb_url", property = "image.thumbUrl"),

    })
    Video getVideoInfoByWorkId(@Param("work_id") long workId);

    @Insert("INSERT INTO t_video(work_id, device_name, play_url) " +
            "VALUES " +
            "(#{workId}, #{deviceName}, #{playUrl})")
    void insertVideo(Video video);
}
