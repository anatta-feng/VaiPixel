package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {

    @Select("SELECT * FROM t_tag ")
    List<Tag> getAllTag();

    @Select("SELECT * FROM t_tag AS t INNER JOIN t_relation_work_tag AS r ON t.tag_id = r.tag_id WHERE r.work_id = #{workId}")
    List<Tag> getWorkTags(long workId);

    @Select("SELECT * FROM t_tag WHERE tag_id = #{id}")
    Tag getTagById(long id);

    @Select("SELECT * FROM t_tag WHERE tag_name = #{name}")
    Tag getTagByName(String name);

    @Insert("INSERT INTO t_tag(tag_name) VALUES (#{tagName})")
    void addTag(Tag tag);

    @Insert("INSERT INTO t_tag(tag_name) VALUES (#{tagName})")
    void addTagByName(String tagName);

    @Insert("INSERT INTO t_relation_work_tag(work_id, tag_id) VALUES (#{workId}, #{tagId})")
    void addTagWorkRelation(long workId, long tagId);

    @Delete("DELETE FROM t_tag WHERE tag_id = #{id}")
    void deleteTagById(long id);
}
