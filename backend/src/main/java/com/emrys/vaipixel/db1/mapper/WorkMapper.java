package com.emrys.vaipixel.db1.mapper;

import com.emrys.vaipixel.db1.enums.WorkTypeEnum;
import com.emrys.vaipixel.db1.model.Photo;
import com.emrys.vaipixel.db1.model.Video;
import com.emrys.vaipixel.db1.model.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WorkMapper {
    @Select("SELECT * FROM work")
    @Results({
            @Result(property = "workType",  column = "work_type", javaType = WorkTypeEnum.class),
    })
    @TypeDiscriminator(javaType = WorkTypeEnum.class, column = "work_type", cases = {
            @Case(value = "photo", type = Photo.class),
            @Case(value = "video", type = Video.class)
    })
    List<Work> getAll();
}
