package com.emrys.vaipixel.db.dao.tag;

import com.emrys.vaipixel.db.model.Tag;
import com.github.pagehelper.PageInfo;

public interface ITagDao {

    boolean isTagExist(Tag tag);

    boolean isTagExist(long tagId);

    boolean isTagExist(String tagName);

    Tag getTagByName(String name);

    Tag getTagById(long tagId);

    PageInfo<Tag> getTags(int pageNum, int pageSize);

    void addTag(String tagName);

    void addTagIfNotExist(String tagName);
}
