package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {
    @Select("SELECT * FROM t_tag AS t INNER JOIN t_relation_work_tag AS r ON t.tag_id = r.tag_id WHERE r.work_id = #{work_id}")
    List<Tag> getWorkTags(@Param("work_id") long workId);

    @Insert("INSERT INTO t_tag(tag_name) VALUES (#{tagName})")
    void addTag(Tag tag);

    @Delete("DELETE FROM t_tag WHERE tag_id = #{id}")
    void deleteTagById(long id);
}
