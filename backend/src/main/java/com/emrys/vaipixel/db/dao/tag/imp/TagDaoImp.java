package com.emrys.vaipixel.db.dao.tag.imp;

import com.emrys.vaipixel.db.dao.tag.ITagDao;
import com.emrys.vaipixel.db.mapper.TagMapper;
import com.emrys.vaipixel.db.model.Tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class TagDaoImp implements ITagDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagDaoImp.class);

    private TagMapper tagMapper;

    @Autowired
    public TagDaoImp(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public boolean isTagExist(Tag tag) {
        return tag != null && tagMapper.getTagById(tag.getId()) != null;
    }

    @Override
    public boolean isTagExist(long tagId) {
        return tagMapper.getTagById(tagId) != null;
    }

    @Override
    public boolean isTagExist(String tagName) {
        return !StringUtils.isEmpty(tagName) && getTagByName(tagName) != null;
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
    public void addTag(String tagName) {
        tagMapper.addTagByName(tagName);
    }

    @Override
    public void addTagIfNotExist(String tagName) {
        if (StringUtils.isEmpty(tagName)) {
            LOGGER.info("addTagIfNotExist tag is null");
        } else if (isTagExist(tagName)) {
            LOGGER.info("addTagIfNotExist tag has exist");
        } else {
            tagMapper.addTagByName(tagName);
        }
    }
}
