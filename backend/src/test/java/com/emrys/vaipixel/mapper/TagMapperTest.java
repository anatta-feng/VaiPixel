package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.db.mapper.TagMapper;
import com.emrys.vaipixel.db.model.Tag;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagMapperTest extends BaseTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void testQuery() {
        List<Tag> workTags = tagMapper.getWorkTags(1);
        System.out.println(workTags);
    }

    @Test
    public void testInsert() {
        Tag tag = new Tag();
        tag.setTagName("视频");
        tagMapper.addTag(tag);
    }
}
