package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Photo;
import org.apache.ibatis.annotations.*;

public interface PhotoMapper {
    @Select("SELECT * FROM t_work AS work INNER JOIN t_photo AS photo ON photo.work_id = work.work_id " +
            "WHERE photo.work_id = #{workId}")
    @Results({
            @Result(column = "author_id", property = "author", one = @One(select = "com.emrys.vaipixel.db.mapper.UserMapper.getUserById")),
            @Result(column = "category_id", property = "category", one = @One(select = "com.emrys.vaipixel.db.mapper.CategoryMapper.getCategoryById")),
            @Result(column = "work_id", property = "tags", many = @Many(select = "com.emrys.vaipixel.db.mapper.TagMapper.getWorkTags")),
            @Result(column = "work_id", property = "workId"),
            @Result(column = "large_url", property = "image.largeUrl"),
            @Result(column = "medium_url", property = "image.mediumUrl"),
            @Result(column = "small_url", property = "image.smallUrl"),
            @Result(column = "thumb_url", property = "image.thumbUrl"),
            @Result(column = "camera_make", property = "cameraParameter.make"),
            @Result(column = "camera_model", property = "cameraParameter.model"),
            @Result(column = "lens", property = "cameraParameter.lens"),
            @Result(column = "focal_length", property = "cameraParameter.focalLength"),
            @Result(column = "aperture", property = "cameraParameter.aperture"),
            @Result(column = "iso", property = "cameraParameter.iso"),
            @Result(column = "shutter", property = "cameraParameter.shutter"),

    })
    Photo getPhotoInfoByWorkId(long workId);

    @Insert("INSERT INTO t_photo(photo_id, work_id, camera, lens, focal_length, aperture, iso, shutter) " +
            "VALUES " +
            "(#{photoId}, #{workId}, #{cameraParameter.camera}, #{cameraParameter.lens}, #{cameraParameter.focalLength}, " +
            "#{cameraParameter.aperture}, #{cameraParameter.iso}, #{cameraParameter.shutter})")
    void insertPhoto(Photo photo);
}
