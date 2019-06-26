package com.emrys.vaipixel.db.dao.tag.imp;

import com.emrys.vaipixel.db.dao.tag.ITagDao;
import com.emrys.vaipixel.db.mapper.TagMapper;
import com.emrys.vaipixel.db.model.Tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagDaoImp implements ITagDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagDaoImp.class);

    @Autowired
    private TagMapper tagMapper;

    @Override
    public boolean isTagExist(Tag tag) {
        return tag != null && tagMapper.getTagById(tag.getTagId()) != null;
    }

    @Override
    public boolean isTagExist(long tagId) {
        return tagMapper.getTagById(tagId) != null;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public Tag getTagById(long tagId) {
        return tagMapper.getTagById(tagId);
    }

    @Override
    public PageInfo<Tag> getTags(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> tags = tagMapper.getAllTag();
        return new PageInfo<>(tags);
    }

    @Override
    public void addTag(Tag tag) {
        tagMapper.addTag(tag);
    }

    @Override
    public void addTagIfNotExist(Tag tag) {
        if (tag == null) {
            LOGGER.info("addTagIfNotExist tag is null");
        } else if (isTagExist(tag)) {
            LOGGER.info("addTagIfNotExist tag has exist");
        } else {
            tagMapper.addTag(tag);
        }
    }
}
