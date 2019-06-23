package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.db.model.Video;
import com.emrys.vaipixel.db.model.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkMapper {
//    @Select("SELECT " +
//            "work.work_id, " +
//            "work.title, " +
//            "work.description, " +
//            "work.created_time, " +
//            "work.updated_time, " +
//            "work.width, " +
//            "work.height, " +
//            "work.type, " +
//            "work.large_url, " +
//            "work.medium_url, " +
//            "work.small_url, " +
//            "work.thumb_url, " +
//            "video.play_url, " +
//            "user.user_id, " +
//            "user.user_name, " +
//            "category.category_id, " +
//            "category.category_name " +
//            "FROM " +
//            "t_work AS work " +
//            "LEFT JOIN t_photo AS photo ON photo.work_id = work.work_id " +
//            "LEFT JOIN t_video AS video ON video.work_id = work.work_id " +
//            "LEFT JOIN t_user AS user ON user.user_id = work.author_id " +
//            "LEFT JOIN t_category AS category ON category.category_id = work.category_id;")
//    @Results({
//            @Result(property = "type",  column = "type", javaType = WorkTypeEnum.class),
//            @Result(property = "image.largeUrl", column = "work.large_url"),
//            @Result(property = "image.mediumUrl", column = "work.medium_url"),
//            @Result(property = "image.smallUrl", column = "work.small_url"),
//            @Result(property = "image.thumbUrl", column = "work.thumb_url"),
//
//            @Result(property = "author", column = "work.author_id", javaType = User.class, one = @One(select = "com.emrys.vaipixel.db.mapper.UserMapper.getUserById")),
//
////            @Result(property = "user.userId", column = "user.user_id"),
////            @Result(property = "user.userName", column = "user.user_name"),
//            @Result(property = "category.categoryId", column = "category.category_id"),
//            @Result(property = "category.categoryName", column = "category.category_name"),
//
//    })
//    @TypeDiscriminator(javaType = WorkTypeEnum.class, column = "type", cases = {
//            @Case(value = "photo", type = Photo.class),
//            @Case(value = "video", type = Video.class, results = {
//                    @Result(property = "playUrl", column = "video.play_url")
//            })
//    })
//    List<Work> getAll();


    @Select("SELECT * FROM t_work " +
            "LEFT JOIN t_photo ON t_photo.work_id = t_work.work_id " +
            "LEFT JOIN t_video ON t_video.work_id = t_work.work_id ")
    @Results({
            @Result(column = "author_id", property = "author", one = @One(select = "com.emrys.vaipixel.db.mapper.UserMapper.getUserById")),
            @Result(column = "category_id", property = "category", one = @One(select = "com.emrys.vaipixel.db.mapper.CategoryMapper.getCategoryById")),
            @Result(column = "work_id", property = "tags", many = @Many(select = "com.emrys.vaipixel.db.mapper.TagMapper.getWorkTags")),
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
            @Case(value = "video", type = Video.class)
    })
    List<Work> getAll();


}
