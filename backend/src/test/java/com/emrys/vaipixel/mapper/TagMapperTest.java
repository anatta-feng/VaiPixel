package com.emrys.vaipixel.mapper;

import com.emrys.vaipixel.db.mapper.TagMapper;
import com.emrys.vaipixel.db.model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void testQuery() {
        List<Tag> workTags = tagMapper.getWorkTags(1);
        System.out.println(workTags);
    }
}
