package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Photo;
import com.emrys.vaipixel.db.model.Work;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PhotoMapper {

    @Select("SELECT  " +
            "photo.id,  " +
            "photo.title,  " +
            "photo.description,  " +
            "photo.create_time,  " +
            "photo.update_time,  " +
            "photo.width,  " +
            "photo.height,  " +
            "photo.row_url,  " +
            "photo.full_url,  " +
            "photo.regular_url,  " +
            "photo.small_url,  " +
            "photo.thumb_url,  " +
            "photo.category_id,  " +
            "photo.author_id  " +
            "FROM  " +
            "photo")
    List<Photo> getAll();

    @Insert("INSERT INTO `vaipixel`.`photo`" +
            "(`id`, `title`, `description`, `width`, `height`, `row_url`, `full_url`, `regular_url`, `small_url`, `thumb_url`, `camera`, `lens`, `focal_length`, `aperture`, `iso`, `shutter`, `category_id`, `author_id`) " +
            "VALUES (#{id}, #{title}, #{description}, #{width}, #{height}, #{rowUrl}, #{fullUrl}, " +
            "#{regularUrl}, #{smallUrl}, #{thumbUrl}, #{camera}, #{lens}, #{focalLength}, #{aperture}," +
            " #{iso}, #{shutter}, #{categoryId}, #{authorId})")
    void insert(Photo work);

    void delete(Work work);
}
